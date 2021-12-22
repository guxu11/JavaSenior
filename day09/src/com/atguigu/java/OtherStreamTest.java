package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.Locale;

/*
其他流
1. 标准输入输出流
2、 打印流
3. 数据流
 */
public class OtherStreamTest {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            System.out.println("请输入：");

            while (true) {
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String uppercase = data.toUpperCase();
                System.out.println(uppercase);
            }
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
        }
    }

    /*
    打印流
     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("./out");
            ps = new PrintStream(fos, true);
            if (ps != null) System.setOut(ps);

            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    数据流  输出
     */
    @Test
    public void test3() throws Exception{
        DataOutputStream dos  = new DataOutputStream(new FileOutputStream("a"));
        dos.writeUTF("hello");
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }

    /*
    数据流  输入
     */
    @Test
    public void test4() throws Exception{
        DataInputStream dis = new DataInputStream(new FileInputStream("a"));
        String word = dis.readUTF();
        boolean b = dis.readBoolean();
        System.out.println(word + " "+ b);
    }

}
