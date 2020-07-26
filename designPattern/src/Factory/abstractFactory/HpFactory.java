package Factory.abstractFactory;

public class HpFactory extends PubFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new HpKeybo();
    }
}
