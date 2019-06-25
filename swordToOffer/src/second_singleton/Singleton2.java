package second_singleton;

/**
 * 对懒汉式进行改造（加同步锁）：虽然在多线程中可以工作，但是效率不高
 */
public class Singleton2 {
    private static Singleton2 singleton = null;

    private Singleton2() {
    }

    public synchronized static Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
