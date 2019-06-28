package Factory.factoryMethod;

public class MainMethod {
    public static void main(String[] args) {
        MouseFactory mouseFactory = new HPMouseFactory();
        Mouse mouse = mouseFactory.createMouse();
        mouse.sayHi();

        mouseFactory = new DellMouseFactory();
        mouse = mouseFactory.createMouse();
        mouse.sayHi();
    }
}
