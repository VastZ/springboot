package com.boot.learn.email;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhang.wenhan
 * @description TestUrlFile
 * @date 2019/6/25 15:50
 */
public class TestUrlFile {

    public static void main(String[] args) throws MalformedURLException {
        String str = "http://sssss";
        System.out.println(str.replaceFirst("http", "https"));


    }

    private static void test(){
        try{
            URL url =new URL("https://file.700du.cn/claim/1561021782/HsyzrSS2xA.pdf");
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
            uc.connect();
            InputStream is = uc.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:/Users/AA/Desktop/123.pdf");
            byte[] b = new byte[1024];
            int length;
            while((length= is.read(b))>0){
                fos.write(b,0,length);
            }
            fos.close();
            is.close();
        } catch (Exception e) {

        }
    }

}
