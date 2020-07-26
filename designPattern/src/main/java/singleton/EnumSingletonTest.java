package singleton;

import org.junit.Test;

public class EnumSingletonTest {
    @Test
    public void testEnum() {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance == instance2);
    }
}

enum EnumSingleton {
    /**
     * 实例
     */
    INSTANCE;
}
