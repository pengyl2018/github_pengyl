package flyweight;

/**
 * 享元模式
 */
public class FlyWeightTest {

}

/**
 * 车票类
 */
interface Ticket {
    void sellTicket(boolean isSoft);
}

class TrianTicket implements Ticket {
    // 始发地
    private String from;
    // 目的地
    private String to;
    // 票价
    public Integer price;
    // 是否是软卧（只有软卧和硬卧两种）
    public boolean isSoft;

    // from和to是内部变量，一旦确定就不变（from和to可以确定一张车票）
    public TrianTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    // isSoft和price是外部变量，由用户确定
    @Override
    public void sellTicket(boolean isSoft) {

        if (isSoft) {
            this.price = 50;
        } else {
            this.price = 30;
        }
        System.out.println(
            "始发地：" + this.from + ",目的地：" + this.to + ",票价：" + this.price + ",是否是软卧：" + (this.isSoft ? "是" : "否"));
    }

    @Override
    public String toString() {
        return "TrianTicket{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", price=" + price + ", isSoft="
            + isSoft + '}';
    }
}

static class TicketFactory {
    private static Map<String, String>
}