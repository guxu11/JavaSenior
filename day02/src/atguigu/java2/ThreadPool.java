package atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: guxu
 * @create: 2021/10/28
 * @description:
 */
public class ThreadPool {
    public static void main(String[] args) {

        // 1. 提供指定线程数量的线程池
        ExecutorService s = Executors.newFixedThreadPool(10);
        System.out.println(s.getClass());
        // 2. 执行指定的线程操作，需要提供实现Runable接口或Callable接口实现类的对象
        s.execute(new NumberThread());  // 适合用于Runable
        s.execute(new NumberThread2());

        s.submit(new NumberThread3());   // 使用于Callable
        // 3. 关闭线程池
        s.shutdown();
    }
}

class NumberThread3 implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100 ; i++) {
            if (i % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
        return null;
    }
}

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}
class NumberThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

