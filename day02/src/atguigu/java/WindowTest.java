package atguigu.java;

/**
 * @author: guxu
 * @create: 2021/10/20
 * @description: 创建三个窗口卖票，总票数为100张，使用继承Thread类的方式来做
 *
 * 存在线程安全问题
 * 如何解决？
 * 1. 同步代码块
 * synchronized (同步监视器) {
 *
 * }
 * 说明：1. 操作
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
    static Object obj = new Object();
    public void run() {
        while (true) {
            synchronized(obj) {

                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }

    }
}
