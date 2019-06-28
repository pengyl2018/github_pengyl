package Factory.singleFactory;

public class MouseFactory {
    public static Mouse createMouse(int i) {
        if (i == 0) {
            return new DellMouse();
        } else {
            return new HpMouse();
        }
    }
}
