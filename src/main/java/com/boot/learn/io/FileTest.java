package com.boot.learn.io;

import java.io.*;

/**
 * @author zhang.wenhan
 * @description FileTest
 * @date 2019/7/15 17:03
 */
public class FileTest {

    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("C:/Users/AA/Desktop/123.txt");
            FileWriter fileWriter = new FileWriter("C:/Users/AA/Desktop/456.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null){
                fileWriter.write(temp);
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
