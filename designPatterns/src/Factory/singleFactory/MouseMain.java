package Factory.singleFactory;

public class MouseMain {
    public static void main(String[] args) {
        Mouse m0 = MouseFactory.createMouse(0);
        m0.sayHi();
        Mouse m1 = MouseFactory.createMouse(1);
        m1.sayHi();
    }
}
