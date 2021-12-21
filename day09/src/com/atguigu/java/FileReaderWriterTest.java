package com.atguigu.java;

import org.junit.Test;

import java.io.*;

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
    /*
    写出数据到硬盘的文件里
     */
    @Test
    public void testFileWriter() throws Exception{
        File file = new File("hello1");
        FileWriter fw = new FileWriter(file, true);
        fw.write("I have a dream!!!!!!!!!!\n");
        fw.write("you also have a dream!!!!!!!!!!!!");
        fw.close();
    }

    @Test
    public void testCopyFile() {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            File srcFile = new File("hello");
            File desFile = new File("hello2");
            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile);
            char[] cbuf = new char[5];
            int len;
            // 每次写出len个字符
            while ((len = fr.read(cbuf)) != -1) fw.write(cbuf, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
