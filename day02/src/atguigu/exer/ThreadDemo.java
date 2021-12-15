package atguigu.exer;

public class ThreadDemo {
    public static void main(String[] args) {
        // 创建Thread的匿名子类
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(i);
                    }
                }
            }
        }.start();
    }

}

class Mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}