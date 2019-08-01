package com.boot.dayask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhang.wenhan
 * @description FileTest
 * @date 2019/8/1 15:52
 */
public class FileTest {

    public static final int size = 10 * 1024;

    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("gap", ".txt");
        FileOutputStream out = new FileOutputStream(file);
        out.write(1);
        out.write(new byte[size]);
        out.write(2);
        out.close();
        FileInputStream in = new FileInputStream(file);
        int first = in.read();
        in.skip(size);
        int last = in.read();
        System.out.println(first + last);

    }

}
