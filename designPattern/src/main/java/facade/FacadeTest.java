package facade;

/**
 * 它可以将一组复杂的类包装到一个简单的外部接口中。
 * 举例说明：一个顾客Customer有一个haveDinner方法，这个方法需要使用三个接口的方法，这三个接口是收银部Payment的pay方法，
 * 厨师部Cook的cook方法还有服务生部的Waiter的上菜serve方法。
 */
public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.haveDinner();
    }
}

class Facade {
    private Payment payment;
    private Cook cook;
    private Waiter waiter;

    public Facade() {
        this.payment = new PaymentImpl();
        this.cook = new CookieImpl();
        this.waiter = new WaitImpl();
    }

    /**
     * 吃饭的过程包括：付钱，做饭，上菜。用到了三个类中的方法
     */
    public void haveDinner() {
        payment.pay();
        cook.cook();
        waiter.serve();
    }
}

interface Payment {
    void pay();
}

class PaymentImpl implements Payment {

    @Override
    public void pay() {
        System.out.println("付钱");
    }
}

interface Cook {
    void cook();
}

class CookieImpl implements Cook {

    @Override
    public void cook() {
        System.out.println("做饭做菜");
    }
}

interface Waiter {
    void serve();
}

class WaitImpl implements Waiter {

    @Override
    public void serve() {
        System.out.println("服务员上菜");
    }
}
