package builder.normal;


/**
 * 建造者模式通常的写法：形成设置属性的链
 * 特点：可以按照顺序，按照需要哪些属性 进行建造，不需要创建很多构造方法
 */
public class BuilderTest {
    public static void main(String[] args) {
        Product product = new Product.Builder().setName("mouse").setCompany("hp").setTime("3y").build();
        Product product2 = new Product.Builder().setName("key").setCompany("dell").build();
        System.out.println(product);
        System.out.println(product2);
    }
}

/**
 * 无参构造抛异常，有参构造为private，这就是要求用户创建实例时全部走建造者模式
 * 省去了所有的get和set方法
 */
class Product {
    private String name;
    private String company;
    private String time;

    /**
     * 无参构造方法抛异常
     */
    public Product() throws Exception {
        throw new Exception("there is no default constructor.");
    }

    /**
     * 唯一的有参构造方法设置为private
     *
     * @param name
     * @param company
     * @param time
     */
    private Product(String name, String company, String time) {
        this.name = name;
        this.company = company;
        this.time = time;
    }

    static class Builder {
        // 属性与Product全量相同
        private String name;
        private String company;
        private String time;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Product build() {
            return new Product(this.name, this.company, this.time);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

