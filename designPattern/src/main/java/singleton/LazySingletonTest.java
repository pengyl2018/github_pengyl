package singleton;

import org.junit.Test;

/**
 * 懒汉模式
 */
public class LazySingletonTest {

    /**
     * 单线程运行时没问题
     */
    @Test
    public void testSingleThread() {
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance == instance2);
    }

    /**
     * 多线程运行时会有问题
     *
     * @throws InterruptedException
     */
    @Test
    public void testMultiThread() throws InterruptedException {
        LazySingleThread myThread = new LazySingleThread();
        Thread t1 = new Thread(myThread, "线程1");
        Thread t2 = new Thread(myThread, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {

    }

    /**
     * 简单的懒汉模式
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }
}


class LazySingleThread implements Runnable {
    @Override
    public void run() {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);
    }
}