package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("img.png"), "r");
            raf2 = new RandomAccessFile(new File("img1.png"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt", "rw");
            raf1.seek(3);
            raf1.write("xyz".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 实现插入的功能
    @Test
    public void test3() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt", "rw");
            raf1.seek(3);
            // 保存指针3后面的所有数据到StringBuilder中
            StringBuilder builder = new StringBuilder((int )new File("hello.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                builder.append(new String(buffer));
            }
            // 调回指针写入xyz
            raf1.seek(3);
            raf1.write("xyz".getBytes(StandardCharsets.UTF_8));

            // 将StringBuilder中的数据写入文件
            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
