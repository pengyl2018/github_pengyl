package singleton;

import org.junit.Test;

public class InnerClassSingletonTest {
    @Test
    public void testSingleton() {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        System.out.println(instance == instance2);
    }

    @Test
    public void testMultiThread() throws InterruptedException {
        InnerClassThread myThread = new InnerClassThread();
        Thread t1 = new Thread(myThread, "线程1");
        Thread t2 = new Thread(myThread, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class InnerClassSingleton {
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {

    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }
}

class InnerClassThread implements Runnable {
    @Override
    public void run() {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(instance);
    }
}