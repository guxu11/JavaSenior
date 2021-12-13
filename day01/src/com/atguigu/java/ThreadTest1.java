package com.atguigu.java;

/**
 * @author: guxu
 * @create: 2021/10/20
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt1);

        t1.start();
        t2.start();


    }
}

class MyThread1 implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
