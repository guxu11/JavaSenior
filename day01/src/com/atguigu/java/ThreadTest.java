package com.atguigu.java;


public class ThreadTest {
    public static void main(String[] args) {
        // 3. 创建Thread子类的对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // 4. 通过此对象调用start()
        t1.start();
        t2.start();

    }
}

// 1. 创建一个继承于Thread的子类
class MyThread extends Thread {
    // 2. 重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
