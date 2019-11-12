package second_singleton;

/**
 * 推荐2
 * 静态内部类：实现按需创建实例
 */
public class Singleton5 {
    private Singleton5() {
    }

    private static class SingletonHolder {
        private static Singleton5 singleton = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.singleton;
    }
}
