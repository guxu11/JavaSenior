package com.atguigu.java;

import org.junit.Test;

import java.io.*;

public class ObjectIOStreamTest {
    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("obj.dat"));
            oos.writeObject(new Person(11, "gg", new Account(10)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("obj.dat"));
            Object obj = ois.readObject();
            Person str = (Person) obj;
            System.out.println(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
