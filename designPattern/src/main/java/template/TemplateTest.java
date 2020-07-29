package template;

/**
 * 模板模式：一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行
 * 主要解决：一些方法通用，却在每一个子类都重新写了这一方法。如数据库连接
 */
public class TemplateTest {
    public static void main(String[] args) {
        Game game = new QqGame();
        game.playGame();
        System.out.println();
        game = new WeixinGame();
        game.playGame();
    }
}

abstract class Game {
    abstract void initial();

    abstract void playing();

    abstract void close();

    /**
     * 玩游戏的骨架就是先初始化，再进行游戏，再关闭游戏
     * 其中每个步骤的实现放在子类中实现
     */
    public final void playGame() {
        initial();
        playing();
        close();
    }
}

class QqGame extends Game {

    @Override
    void initial() {
        System.out.println("QQ游戏初始化");
    }

    @Override
    void playing() {
        System.out.println("QQ游戏进行中");
    }

    @Override
    void close() {
        System.out.println("QQ游戏关闭");
    }
}

class WeixinGame extends Game {

    @Override
    void initial() {
        System.out.println("微信游戏初始化");
    }

    @Override
    void playing() {
        System.out.println("微信游戏进程中");
    }

    @Override
    void close() {
        System.out.println("微信游戏关闭");
    }
}