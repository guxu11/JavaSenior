package atguigu.java;

/**
 * @author: guxu
 * @create: 2021/10/20
 * @description: 创建三个窗口卖票，总票数为100张，使用继承Thread类的方式来做
 *
 * 实现Runable的方法，使用同步方法


*/
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {
    private static int ticket = 100;
    static Object obj = new Object();

    private synchronized void show() {   // 同步监视器：this
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
    public  void run() {
        while (true) {
            show();
        }

    }
}
