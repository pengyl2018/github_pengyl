package second_singleton;

/**
 * 懒汉式：只适用于单线程环境
 */
public class Singleton1 {
    private static Singleton1 singleton = null;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}
