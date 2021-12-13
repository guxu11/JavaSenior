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
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window4 extends Thread {
    private static int ticket = 100;
    static Object obj = new Object();

    private static synchronized void show() {  // 同步监视器： Window4.class
//    private synchronized void show() {  // 同步监视器： t1, t2, t3
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }
    public void run() {
        while (true) {
//            synchronized(obj) {

//            }
            show();
        }

    }
}
