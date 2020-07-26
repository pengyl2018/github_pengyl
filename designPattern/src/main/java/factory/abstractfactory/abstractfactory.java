package factory.abstractfactory;

/**
 * 抽象工厂模式：以数据库工具库为例
 */
public class AbstractFactory {
    public static void main(String[] args) {
//        IDataUtil dataUtil = new MysqlUtil();
        IDataUtil dataUtil = new OracleUtil();
        Connection connection = dataUtil.getConnection();
        connection.doConnection();
        Command command = dataUtil.getCommand();
        command.execCommand();
    }
}

interface Connection {
    void doConnection();
}

interface Command {
    void execCommand();
}

interface IDataUtil {
    Connection getConnection();

    Command getCommand();
}

class MysqlConnection implements Connection {
    @Override
    public void doConnection() {
        System.out.println("mysql connect.");
    }
}

class MysqlCommand implements Command {
    @Override
    public void execCommand() {
        System.out.println("mysql command.");
    }
}

class MysqlUtil implements IDataUtil {

    @Override
    public Connection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public Command getCommand() {
        return new MysqlCommand();
    }
}

class OracleConnection implements Connection {
    @Override
    public void doConnection() {
        System.out.println("oracle connect.");
    }
}

class OracleCommand implements Command {
    @Override
    public void execCommand() {
        System.out.println("oracle command.");
    }
}

class OracleUtil implements IDataUtil {

    @Override
    public Connection getConnection() {
        return new OracleConnection();
    }

    @Override
    public Command getCommand() {
        return new OracleCommand();
    }
}