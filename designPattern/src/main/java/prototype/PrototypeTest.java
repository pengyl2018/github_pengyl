package prototype;

/**
 * 原型模式：主要是对象的克隆
 */
public class PrototypeTest {
    public static void main(String[] args) {
        // 初始化类
        Person person = new Person();
        Eye eye = new Eye();
        eye.setColor("bule");
        eye.setSize(12);
        person.setEye(eye);
        person.setAge(21);
        person.setName("张三");
        // 克隆类
        Person person1 = person.clone();
        System.out.println("原始类" + person.toString());
        System.out.println("克隆后的类" + person1.toString());
    }
}

class Person implements Cloneable{
    private String name;
    private Integer age;
    private Eye eye;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Eye getEye() {
        return eye;
    }

    public void setEye(Eye eye) {
        this.eye = eye;
    }

    @Override
    public Person clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
            person.setEye(this.eye.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eye=" + eye +
                '}';
    }
}

class Eye implements Cloneable{
    private Integer size;
    private String color;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Eye clone() throws CloneNotSupportedException {
        return (Eye) super.clone();
    }

    @Override
    public String toString() {
        return "Eye{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
