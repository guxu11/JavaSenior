package atguigu.java2;

import java.beans.Customizer;
import java.sql.SQLOutput;
import java.util.concurrent.CompletionService;

/**
 * @author: guxu
 * @create: 2021/10/27
 * @description:
 *      生产者/消费者问题
 *      分析：
 *          1. 是否是多线程问题？ 是，生产者线程，消费者线程
 *          2. 是否有共享数据？ 是， 店员（或产品）
 *          3. 如何解决线程安全问题？ 同步机制，三种方法
 *          4. 是否涉及到线程通信？ 是
 */


public class ProductTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Constomer c1 = new Constomer(clerk);
        c1.setName("消费者1");

        Constomer c2 = new Constomer(clerk);
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();

    }

}


class Clerk {
    private int productCount = 0;

    // 生产产品
    public synchronized void produceProduct() {
        if (productCount < 20) {
            productCount ++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productCount + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // wait()
        }
    }
    // 消费产品
    public synchronized void consumProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + ": 开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // wait();
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer (Clerk c) {
        this.clerk = c;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始生产产品......");

        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

class Constomer extends Thread {
    private Clerk clerk;

    public Constomer(Clerk c) {
        this.clerk = c;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始消费产品......");

        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumProduct();
        }
    }
}

