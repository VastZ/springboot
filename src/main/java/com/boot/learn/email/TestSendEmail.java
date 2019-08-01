package com.boot.learn.email;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

public class TestSendEmail {

    private static Logger log = Logger.getLogger("TestSendEmail");

    public static void main(String[] args) throws AddressException, MessagingException, IOException {

        String serverAddress = "smtp.263xmail.com";
        String username = "salesadmin@700du.cn";
        String password = "700du@700du";
        String from = "salesadmin@700du.cn";
        String emailReceiver = "zhangwenhan24@163.com";
        String subject = "你好啊";
        String htmlContents = "一般般";
        String[] attachFileNames = {"https://file.700du.cn/claim/1561021782/HsyzrSS2xA.pdf", "https://pic.700du.cn//dev1/0/001/017/0001017825.fid"};
        String chineseName = "";
        String[] attachFileRealNames = {"测试文件.pdf"};
        sslSendAttachments(serverAddress, username , password, from, emailReceiver, subject, htmlContents, attachFileNames, chineseName, attachFileRealNames);
    }

    public static boolean sslSendAttachments(String serverAddress, String user,
                                             String pwd, String from, String emailReceiver, String subject,
                                             String htmlContents, String[] attachFileNames,String chineseName,String[] attachFileRealNames)
            throws AddressException, MessagingException, IOException{
        //   Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        log.info("serverAddress = " + serverAddress);
        log.info("user = " + user);
        log.info("pwd = " + pwd);
        log.info("from = " + from);
        log.info("emailReceiver = " + emailReceiver);
        log.info("subject = " + subject);
        log.info("htmlContents = " + htmlContents);
        log.info("attachFileNames = " + JSON.toJSONString(attachFileNames));
        Properties props = new Properties();
        //邮箱服务器
        props.put("mail.smtp.host",serverAddress );
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

        final String username = user;
        final String password = pwd;
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }});
        Message msg = new MimeMessage(session);

        // 设置发件人和收件人
        msg.setFrom(new InternetAddress("\""
                + javax.mail.internet.MimeUtility.encodeText(chineseName)
                + "\"<" + from + ">"));// 发件人
        String emailReceivers[] = emailReceiver.split(",");
        InternetAddress[] address = new InternetAddress[emailReceivers.length];
        for(int i=0;i<emailReceivers.length;i++){
            address[i] = new InternetAddress(emailReceivers[i]);
        }
        // 多个收件人地址
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject); // 标题
        //msg.setContent(htmlContents + getMailCorpright(),"text/html;charset=gbk");
        msg.setSentDate(new Date());

        // MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart multiPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart bodyPart = new MimeBodyPart();
        // 设置html邮件消息内容
        bodyPart.setContent(htmlContents + "","text/html;charset=gbk");
        multiPart.addBodyPart(bodyPart);

        //添加附件
        if(attachFileNames.length != 0){
            int i = 0;
            for(String attachFile : attachFileNames){

                bodyPart=new MimeBodyPart();
                DataSource ds=new FileDataSource(attachFile); //得到数据源
                if(attachFile.contains("http")){
                    try{
                        URL url =new URL(attachFile);

                        ds =new URLDataSource(url);
                        bodyPart.setDataHandler(new DataHandler(ds)); //得到附件本身并放入BodyPart
                        bodyPart.setFileName(MimeUtility.encodeText(attachFileRealNames[i]));  //得到文件名并编码（防止中文文件名乱码）同样放入BodyPart
                        //bodyPart.setFileName(MimeUtility.encodeText(ds.getName().substring(ds.getName().lastIndexOf("/")+1)));  //得到文件名并编码（防止中文文件名乱码）同样放入BodyPart

                    }catch(Exception e){
                        log.info("邮件附件提取文件报错，路径： attachFile = " +attachFile);
                        //e.printStackTrace();
                        log.info("邮件附件提取文件错误： 报错信息"+e.getStackTrace());
                    }
                }else{
                    bodyPart.setDataHandler(new DataHandler(ds)); //得到附件本身并放入BodyPart
                    bodyPart.setFileName(MimeUtility.encodeText(attachFileRealNames[i]));  //得到文件名并编码（防止中文文件名乱码）同样放入BodyPart
                }
                i++;
                multiPart.addBodyPart(bodyPart);
            }
        }
        // 设置邮件消息的主要内容
        msg.setContent(multiPart);

        // 发送信件  又发了一遍
        Transport trans = session.getTransport("smtp");
        trans.connect(serverAddress, user, pwd);

        if (trans.isConnected()) {
            trans.sendMessage(msg, msg.getAllRecipients());
            trans.close();
        }
        log.info("EmailUtil ssl协议邮件发送打印" +msg.toString());
        return true;
    }

    public static boolean sslSendAttachments1(String htmlContents, String attachFile, String chineseName,
                                             String attachFileRealName) throws AddressException, MessagingException, IOException {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.263xmail.com");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

        final String username = "salesadmin@700du.cn";
        final String password = "700du@700du";
        String from = "salesadmin@700du.cn";

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message msg = new MimeMessage(session);

        // 设置发件人和收件人
        msg.setFrom(new InternetAddress(
                "\"" + javax.mail.internet.MimeUtility.encodeText(chineseName) + "\"<" + from + ">"));// 发件人
        String emailReceiver = "zhangwenhan24@163.com";
        String emailReceivers[] = emailReceiver.split(",");
        InternetAddress[] address = new InternetAddress[emailReceivers.length];
        for (int i = 0; i < emailReceivers.length; i++) {
            address[i] = new InternetAddress(emailReceivers[i]);
        }
        // 多个收件人地址
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject("我是測試"); // 标题
        msg.setSentDate(new Date());

        // MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart multiPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart bodyPart = new MimeBodyPart();
        // 设置html邮件消息内容
        bodyPart.setContent(htmlContents, "text/html;charset=gbk");
        // multiPart.addBodyPart(bodyPart);

        // 添加附件
        bodyPart = new MimeBodyPart();
        DataSource ds = new FileDataSource(attachFile); // 得到数据源
        try {
            URL url = new URL(attachFile);
            ds = new URLDataSource(url);
            bodyPart.setDataHandler(new DataHandler(ds)); // 得到附件本身并放入BodyPart
            bodyPart.setFileName(MimeUtility.encodeText(attachFileRealName)); // 得到文件名并编码（防止中文文件名乱码）同样放入BodyPart
            // bodyPart.setFileName(MimeUtility.encodeText(ds.getName().substring(ds.getName().lastIndexOf("/")+1)));
            // //得到文件名并编码（防止中文文件名乱码）同样放入BodyPart

        } catch (Exception e) {
            log.info("邮件附件提取文件报错，路径： attachFile = " + attachFile);
            // e.printStackTrace();
            log.info("邮件附件提取文件错误： 报错信息" + e.getStackTrace());
        }
        multiPart.addBodyPart(bodyPart);
        // 设置邮件消息的主要内容
        msg.setContent(multiPart);
        // 发送信件 又发了一遍
        Transport.send(msg);

        // Transport trans = session.getTransport("smtp");
        // trans.connect("smtp.263xmail.com", user, pwd);
        //
        // if (trans.isConnected()) {
        // trans.sendMessage(msg, msg.getAllRecipients());
        // trans.close();
        // }
        log.info("EmailUtil ssl协议邮件发送打印" + msg.toString());
        return true;
    }



}
