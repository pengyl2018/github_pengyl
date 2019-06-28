package Factory.abstractFactory;

public class MainMethod {
    public static void main(String[] args) {
        PubFactory pubFactory = new HpFactory();
        Mouse mouse = pubFactory.createMouse();
        Keybo keybo = pubFactory.createKeybo();
        mouse.sayHi();
        keybo.sayHi();
    }
}
