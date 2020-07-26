package factory.factorymethod;

/**
 * 实现方式：一个产品接口，对应多个具体产品，一个工厂，对应多个具体工厂
 * 不考虑产品族时使用工厂方法模式即可（产品族举例子：苹果品牌的手机、电脑、手表等产品组成一个产品族）
 */
public class MainMethod {
    public static void main(String[] args) {
        Factory factory = new AppleFactory();
        Phone phone = factory.createPhone();
        phone.sayHello();

        Factory factory2 = new MiFactory();
        Phone phone2 = factory.createPhone();
        phone.sayHello();
    }
}

interface Phone {
    void sayHello();
}

class ApplePhone implements Phone {

    @Override
    public void sayHello() {
        System.out.println("用苹果手机打电话");
    }
}

class MiPhone implements Phone {

    @Override
    public void sayHello() {
        System.out.println("用小米手机大电话");
    }
}

interface Factory {
    Phone createPhone();
}

class AppleFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }
}

class MiFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new MiPhone();
    }
}