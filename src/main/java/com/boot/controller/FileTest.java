package com.boot.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @author zhang.wenhan
 * @description FileTest
 * @date 2019/7/18 13:47
 */
public class FileTest {

    public static void main(String[] args) {
//        String tempString = "[00:00:32] [Error] [接收erp信息:] : <?xml version=\"1.0\" encoding=\"utf-8\"?><root><Type>CHECKPAYVOUCHER</Type><ERPPolicyKey>PC180629000000000001</ERPPolicyKey><PayVoucherKey>PC180629000000000001</PayVoucherKey><BizType>2</BizType><CompKey>CO070621000000000003</CompKey><CSUM>27.0</CSUM><prePolicyCode>INDENT0000415008SS56</prePolicyCode><policyCode>INDENT0000415008SS56</policyCode><policyYear>0</policyYear><timeperYear>0</timeperYear><prodName>华泰财险个人综合意外保障</prodName><prodKey>CD170710000000000005</prodKey><holder>彭锡强</holder><insurant>彭锡强</insurant><fee>100.0</fee><stype>1</stype><ackDate>2018-07-03</ackDate><payDate>2018-06-29</payDate></root>";
//        tempString = tempString.substring(tempString.indexOf("<"));
////        System.out.println(tempString);
////        System.out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?><root><Type>CHECKPAYVOUCHER</Type><ERPPolicyKey>".length());
////        System.out.println("PC180629000000000001".length());
//        String str = tempString.substring(136, 156);
//        System.out.println(str);
//        System.out.println(tempString);
        read2();

    }

    public static void read() {
        File file = new File("C:/Users/AA/Desktop/all_1.log");
        File excel = new File("C:/Users/AA/Desktop/request.xls");//Excel文件生成后存储的位置。
//        HSSFWorkbook
        XSSFWorkbook wb = new XSSFWorkbook ();
        XSSFSheet sheet = wb.createSheet("sheet1");
        XSSFRow row0 = sheet.createRow(0);
        XSSFCell cell00 = row0.createCell(0);
        cell00.setCellValue("erp主键");
        XSSFCell cell01 = row0.createCell(1);
        cell01.setCellValue("请求报文");
        int line = 1;
        String[] strs;
        String xml;
        String key;
        String tempString = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             ByteArrayOutputStream os = new ByteArrayOutputStream();
             OutputStream fos = new FileOutputStream(excel)) {
            while ((tempString = reader.readLine()) != null) {
                // 把当前行号显示出来
                tempString.substring(tempString.indexOf("]", 3));
                if (StringUtils.isNotBlank(tempString)) {
                    xml = tempString.substring(tempString.indexOf("<"));
                    key = tempString.substring(136, 156);
                    XSSFRow row = sheet.createRow(line);
                    XSSFCell cell = row.createCell(0);
                    cell.setCellValue(key);
                    XSSFCell cell1 = row.createCell(1);
                    cell1.setCellValue(xml);
                }
                line++;
            }
            wb.write(os);
            wb.write(fos);
        } catch (IOException e) {
            System.out.println(tempString);
            e.printStackTrace();
        }
        System.out.println("一共处理了" + line + "行");
    }


    public static void read2() {
        File file = new File("C:/Users/AA/Desktop/all_1.log");
        File keys = new File("C:/Users/AA/Desktop/keys.txt");//Excel文件生成后存储的位置。
        File xmls = new File("C:/Users/AA/Desktop/xmls.txt", "");//Excel文件生成后存储的位置。

        int line = 1;
        String[] strs;
        String xml;
        String key;
        String tempString = null;
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
            FileWriter keyWriter = new FileWriter(keys,true);
             Writer xmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmls)))
            ) {
            while ((tempString = reader.readLine()) != null) {
                // 把当前行号显示出来
                if (StringUtils.isNotBlank(tempString)) {
                    xml = tempString.substring(tempString.indexOf("<"));

                    key = xml.substring(136, 156);
                    //
                    if (!xml.contains("<prePolicyCode>INDENT") && !key.startsWith("PC")){
                        keyWriter.write(key + "\n");
                        xmlWriter.write(xml + "\n");
                    }
                }
                line++;
            }
        } catch (IOException e) {
            System.out.println(tempString);
            e.printStackTrace();
        }
        System.out.println("一共处理了" + line + "行");
    }
}
