package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
使用字节流InputOutputStream处理文本文件可能出现乱码，因为utf-8中有的字符不止占一个字节
 */
public class FileInputOutputStearmTest {
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("img.png");
            File file1 = new File("img1.png");
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
    // 指定路径文件的复制
    public void FileCopy(String srcPath, String desPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(desPath);
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    @Test
    public void test() {
        String startPath = "/Users/guxu/Movies/collections/yellow_ziyi/VID_20201211_001232.mp4";
        String desPath = "./zy.mp4";
        long start = System.currentTimeMillis();
        FileCopy(startPath, desPath);
        long end = System.currentTimeMillis();
        System.out.println(end - start); // 309ms
    }
}
