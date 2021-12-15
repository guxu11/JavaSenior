package atguigu.exer;

import java.sql.SQLOutput;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: guxu
 * @create: 2021/10/26
 * @description:
 */
public class withdrawMoneyTest {
    public static void main(String[] args) {
        WithdrawMoney wd = new WithdrawMoney();
        Thread t1 = new Thread(wd);
        Thread t2 = new Thread(wd);

        t1.start();
        t2.start();

    }

}

class WithdrawMoney implements Runnable{
    private int total = 0;
    private final ReentrantLock lock = new ReentrantLock();

    private void withdraw() {
        while (true) {
            try {
                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (total < 30000) {
                    total += 1000;
                    System.out.println("余额为" + total + ", 是" + Thread.currentThread().getName() + "存的");
                }else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
    @Override
    public void run() {
        withdraw();
    }
}
