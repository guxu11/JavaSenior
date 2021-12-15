package atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: guxu
 * @create: 2021/10/28
 * @description:
 */
public class ThreadNew {
    public static void main(String[] args) {
        // 3. 创建Callable实现类的对象
        NumThread nt = new NumThread();
        // 4. 将此Callable实现类的对象传入FutureTask构造器中，创建FutureTask对象
        FutureTask ft = new FutureTask(nt);
        // 5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(ft).start();
        try {
            // 6。获取Callable中call()的返回值
            // get()方法返回值即为futuretask构造器参数Callable实现类重写的call()的返回值
            Object sum = ft.get();
            System.out.println("总和为" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}

class NumThread implements Callable {
    // 实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
