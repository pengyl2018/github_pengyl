package adapter.v2;

/**
 * class适配器模式，缺点：最后返回的适配器对象可以访问到多余的方法，在这个例子中，可以访问到out220v这个方法
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.out5v();
//        adapter.out220v();  这一行代码在支配器模式看来不应该被访问到
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

class Adapter extends Adaptee implements Target {

    @Override
    public int out5v() {
        int adaptee = super.out220v();
        System.out.println("电压转化得到5v");
        return 5;
    }
}
