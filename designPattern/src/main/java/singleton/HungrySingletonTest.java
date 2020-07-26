package singleton;

import org.junit.Test;

/**
 * 饿汉模式
 */
public class HungrySingletonTest {

    @Test
    public void testSingleThread() {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance == instance2);
    }
}


class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}