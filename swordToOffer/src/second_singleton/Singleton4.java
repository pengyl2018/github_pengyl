package second_singleton;

/**
 * 推荐1
 * 恶汉式：利用静态构造函数
 * 缺点：过早创建实例，从而降低内存的使用效率
 */
public class Singleton4 {
    private static final Singleton4 singleton = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return singleton;
    }
}
