package com.atguigu.java;

import org.junit.Test;

import java.io.*;

public class FileBufferedTest {
    public void copyFileWithBuffered(String srcPath, String desPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File desFile = new File(desPath);
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testBufferedReaderWriter(String srcPath, String desPath) {
        BufferedReader br = null;
        BufferedWriter wr = null;
        try {
            br = new BufferedReader(new FileReader(new File(srcPath)));
            wr = new BufferedWriter(new FileWriter(new File(srcPath)));
            String data;
            while ((data = br.readLine()) != null) wr.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (wr != null) {

                try {
                    wr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test() {
        String srcPath = "/Users/guxu/Movies/collections/yellow_ziyi/VID_20201211_001232.mp4";
        String desPath = "./zy.mp4";
        long start = System.currentTimeMillis();
        copyFileWithBuffered(srcPath, desPath);
        long end = System.currentTimeMillis();
        System.out.println(end - start); //109ms
    }
}
