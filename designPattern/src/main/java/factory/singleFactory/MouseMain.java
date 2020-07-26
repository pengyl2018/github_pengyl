package factory.singlefactory;

public class MouseMain {
    public static void main(String[] args) {
        Mouse m0 = MouseFactory.createMouse(0);
        m0.sayHi();
        Mouse m1 = MouseFactory.createMouse(1);
        m1.sayHi();
    }
}

class MouseFactory {
    public static Mouse createMouse(int i) {
        if (i == 0) {
            return new DellMouse();
        } else {
            return new HpMouse();
        }
    }
}

interface Mouse {
    void sayHi();
}


class DellMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("dell mouse");
    }
}

class HpMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("hp mouse");
    }
}
