package factory.abstractfactory;

/**
 * 抽象工厂模式：以电子产品举例子
 * 实现方式：一个产品接口，对应多个具体产品，一个工厂，对应多个具体工厂每个工厂里的产品组成一个产品族
 * 需要考虑产品族时使用抽象工厂模式（某个品牌的诸多产品组成一个产品族，举例子：苹果品牌的手机、电脑、手表等产品组成一个产品族）
 */
public class AbstractElectronicFactory {
    public static void main(String[] args) {
        Factory factory = new AppleFactory();
        Book book = factory.createBook();
        book.play();
        Phone phone = factory.createPhone();
        phone.sayHello();

        Factory factory2 = new MiFactory();
        Book book2 = factory2.createBook();
        book2.play();
        Phone phone2 = factory2.createPhone();
        phone2.sayHello();
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
        System.out.println("用小米手机打电话");
    }
}

interface Book {
    void play();
}

class AppleBook implements Book {

    @Override
    public void play() {
        System.out.println("用苹果电脑打游戏");
    }
}

class MiBook implements Book {

    @Override
    public void play() {
        System.out.println("用小米电脑打游戏");
    }
}

interface Factory {
    Phone createPhone();
    Book createBook();
}

class AppleFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public Book createBook() {
        return new AppleBook();
    }
}

class MiFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new MiPhone();
    }

    @Override
    public Book createBook() {
        return new MiBook();
    }
}