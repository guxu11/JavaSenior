package com.atguigu.java;

/**
 * @author: guxu
 * @create: 2021/10/20
 * @description: 创建三个窗口卖票，总票数为100张，使用继承Thread类的方式来做
 *
 * 存在线程安全问题
*/
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread {
    private static int ticket = 100;

    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ": 卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }

        }

    }
}
