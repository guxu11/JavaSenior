package atguigu.java1;

/**
 * @author: guxu
 * @create: 2021/10/26
 * @description: 使用同步机制将单例模式中的懒汉式改写成线程安全的
 */
public class BankTest {


}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() { // 锁是Bank.class
        // 方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//        }
//
//        return instance;

        // 方式二: 效率更高
        if (instance == null) {     // 加一个条件判断，为空的话线程不进入
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
//    public static synchronized Bank getInstance() { // 锁是Bank.class
//        if (instance == null) {
//            instance = new Bank();
//        }
//
//        return instance;
//    }
    }
}
