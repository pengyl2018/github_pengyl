package strategy;

/**
 * 策略模式：
 * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 * 何时使用：一个系统有许多许多类，而区分它们的只是他们直接的行为。
 * 如何解决：将这些算法封装成一个一个的类，任意地替换。
 */
public class StrategyTest {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        Context context = new Context(new OperatorAdd());
        System.out.println("两数之和：" + context.compute(num1, num2));
        context = new Context(new OperatorSubstract());
        System.out.println("两数之差：" + context.compute(num1, num2));
        context = new Context(new OperatorMutiple());
        System.out.println("两数之积：" + context.compute(num1, num2));
    }
}

interface Operator {
    int compute(int num1, int num2);
}

class OperatorAdd implements Operator {

    @Override
    public int compute(int num1, int num2) {
       return num1 + num2;
    }
}

class OperatorSubstract implements Operator {

    @Override
    public int compute(int num1, int num2) {
        return num1 - num2;
    }
}

class OperatorMutiple implements Operator {

    @Override
    public int compute(int num1, int num2) {
        return num1 * num2;
    }
}

/**
 * 使用策略的类
 */
class Context implements Operator {

    private Operator opertator;

    public Context(Operator opertator) {
        this.opertator = opertator;
    }

    @Override
    public int compute(int num1, int num2) {
        return opertator.compute(num1, num2);
    }
}