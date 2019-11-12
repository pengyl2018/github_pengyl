package second_singleton;

/**
 * 对懒汉式进行改造（双重锁）：加同步锁前后两次判断
 * 我们只是在实例创建之前需要加锁，保证只创建出一个实例，而当创建之后，已经不需要执行加锁操作了
 */
public class Singleton3 {
    private static Singleton3 singleton = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
