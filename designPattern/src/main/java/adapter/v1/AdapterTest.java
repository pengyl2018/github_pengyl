package adapter.v1;

/**
 * 对象适配器模式
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        // 代码语义为：以原始类为输入，经过支配器类的适配，返回一个目标类的对象
        Target target = new Adapter(adaptee);
        target.out5v();
    }
}

class Adaptee {
    public int out220v() {
        System.out.println("产生220v电压");
        return 220;
    }
}

interface Target {
    int out5v();
}

class Adapter implements Target {

    private Adaptee adaptee;

    /**
     * 将目标类作为支配器类的构造方法的参数
     *
     * @param adaptee
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int out5v() {
        int adaptee = this.adaptee.out220v();
        System.out.println("电压转化得到5v");
        return 5;
    }
}