package atguigu.java;

/**
 * @author: guxu
 * @create: 2021/10/20
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt1);
        Thread t3 = new Thread(mt1);

        t1.start();
        t2.start();
        t3.start();


    }
}

class MyThread1 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    public void run() {
        while(true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}
