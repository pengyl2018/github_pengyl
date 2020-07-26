package singleton;

import org.junit.Test;

public class LazySingletonDoubleCheckTest {

    /**
     * 多线程运行时没问题
     *
     * @throws InterruptedException
     */
    @Test
    public void testMultiThread() throws InterruptedException {
        LazySingleThreadDoubleCheck myThread = new LazySingleThreadDoubleCheck();
        Thread t1 = new Thread(myThread, "线程1");
        Thread t2 = new Thread(myThread, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class LazySingletonDoubleCheck {
    /**
     * 用volatile防止指令重排序
     */
    private volatile static LazySingletonDoubleCheck instance;

    private LazySingletonDoubleCheck() {

    }

    /**
     * 加上双重检查的懒汉模式
     *
     * @return
     */
    public static LazySingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (LazySingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new LazySingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}

class LazySingleThreadDoubleCheck implements Runnable {
    @Override
    public void run() {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);
    }
}