package flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 * 场景：一段时间内有1000次请求，访问车票信息，要求根据出发地，目的地，和软卧硬卧信息获取车票信息
 */
public class FlyWeightTest {
    int count = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    Ticket ticket = TicketFactory.getTicket("beijing", "shanghai");
                    ticket.sellTicket("true");
                }
                ;
            }).start();
        }
    }

    static class TicketFactory {
        private static Map<String, Ticket> tickerMap = new ConcurrentHashMap<>();

        public static synchronized Ticket getTicket(String from, String to) {
            // 以内部变量作为key
            String key = from + "-" + to;
            Ticket ticket = tickerMap.get(key);
            if (ticket == null) {
                System.out.println("新建ticket对象");
                ticket = new TrianTicket(from, to);
                tickerMap.put(key, ticket);
            }
            return ticket;
        }
    }
}

/**
 * 车票类
 */
interface Ticket {
    void sellTicket(String isSoft);
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

    // from和to是内部状态，一旦确定就不变（from和to可以确定一张车票）
    public TrianTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    // isSoft和price是外部状态，由用户确定
    @Override
    public void sellTicket(String isSoft) {
        boolean isSoftBool = Boolean.valueOf(isSoft);
        if (isSoftBool) {
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

