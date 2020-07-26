package builder.standard;

/**
 * 标准写法：通常不用这么标准
 *
 * 建造者模式，场景：建造模型的属性时有先后顺序
 * 代码特点：需要一个建造者接口；定义一个特定的建造者实现此接口；需要一个操纵者（director），内部有建造者，有创建各种属性的方法
 */
public class BuilderTest {

    public static void main(String[] args) {
        ProductBuilder builder = new DefaultProductBuilder();
        Director director = new Director(builder);
        Product product = director.makeProduct("mouse", "hp", "2years");
        System.out.println(product);
    }
}

interface ProductBuilder {
    void buildName(String name);

    void buildCompany(String company);

    void buildTime(String time);

    Product build();
}

class DefaultProductBuilder implements ProductBuilder {
    private Product product = new Product();

    @Override
    public void buildName(String name) {
        product.setName(name);
    }

    @Override
    public void buildCompany(String company) {
        product.setCompany(company);
    }

    @Override
    public void buildTime(String time) {
        product.setTime(time);
    }

    @Override
    public Product build() {
        return product;
    }
}

class Director {
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String name, String company, String time) {
        builder.buildName(name);
        builder.buildCompany(company);
        builder.buildTime(time);
        return builder.build();
    }
}


class Product {
    private String name;
    private String company;
    private String time;

    public Product() {

    }

    public Product(String name, String company, String time) {
        this.name = name;
        this.company = company;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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