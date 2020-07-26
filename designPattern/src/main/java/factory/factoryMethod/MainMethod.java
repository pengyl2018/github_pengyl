package factory.factorymethod;

/**
 * 将工厂方法的具体实现放到子类中实现
 */
public class MainMethod {
    public static void main(String[] args) {
        KeyFactory keyFactory = new HpKeyFactory();
        Key key = keyFactory.createKey();
        key.sayHi();

        keyFactory = new DellKeyFactory();
        key = keyFactory.createKey();
        key.sayHi();
    }
}

interface Key {
    void sayHi();
}

interface KeyFactory {
    Key createKey();
}

class DellKey implements Key {
    @Override
    public void sayHi() {
        System.out.println("dell key");
    }
}

class HpKey implements Key {
    @Override
    public void sayHi() {
        System.out.println("hp key");
    }
}

class DellKeyFactory implements KeyFactory {
    @Override
    public Key createKey() {
        return new DellKey();
    }
}

class HpKeyFactory implements KeyFactory {
    @Override
    public Key createKey() {
        return new HpKey();
    }
}


