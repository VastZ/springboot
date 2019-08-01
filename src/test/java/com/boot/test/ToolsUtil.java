package com.boot.test;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToolsUtil {

    private static final Logger logger = LoggerFactory.getLogger(ToolsUtil.class);

    public static String getMD5(String source) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
                                      // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
                                           // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                                           // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                                                         // >>>
                                                         // 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串

        } catch (Exception e) {
            logger.error("exception", e);
        }
        return s;
    }

    public static Integer calcPayedDue(Date start, int month) {
        try {
            Calendar rightNow = Calendar.getInstance();
            Date today = new Date();
            rightNow.setTime(today);
            Calendar cal = Calendar.getInstance();
            cal.setTime(start);
            int d1 = rightNow.get(Calendar.DAY_OF_MONTH);
            int d2 = cal.get(Calendar.DAY_OF_MONTH);
            int y1 = rightNow.get(Calendar.YEAR);
            int y2 = cal.get(Calendar.YEAR);
            int m1 = rightNow.get(Calendar.MONTH);
            int m2 = cal.get(Calendar.MONTH);
            int diff = (y1 * 12 + m1) - ((y2 * 12) + m2) + ((d2 >= d1) ? 0 : 1);
            cal.add(Calendar.MONTH, month);
            if (cal.after(rightNow)) {
                return diff;
            } else {
                return month;
            }
        } catch (Exception e) {
            logger.error("exception", e);
        }
        return null;
    }
    
    public static Date getYearAndMonthYYYYMMDD(Date dt, int during) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        if (during > 0) {
            rightNow.add(Calendar.MONTH, during);
        }
        return rightNow.getTime();
    }

}
