package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWriterTest {
    /*
    将day09/hello 读进内存中
    */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            // 1. 产生要操作的对象，这里是File
            File file = new File("hello"); // 对象当前工程的路径
            System.out.println(file.getAbsolutePath());
            // 2. 实例化流对象
            fr = new FileReader(file);
            // 3. 数据读入
            // read(): 返回读入的第一个字符。如果达到文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 4. 关闭流
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("hello");
            fr = new FileReader(file);
            char[] cbuff = new char[5];
            int len;
            while ((len = fr.read(cbuff)) != -1) {
                // 方法一
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuff[i]);
//                }
                // 方法二
                String str = new String(cbuff, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("day09/hello");
        System.out.println(file.getAbsolutePath());  // 对于当前整个工程
    }

}
