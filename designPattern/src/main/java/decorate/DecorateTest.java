package decorate;

/**
 * 装饰器模式：这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 */
public class DecorateTest {
	public static void main(String[] args) {
		Animal animal = new Chicken();
		SuperAnimal superAnimal = new SuperChecken(animal);
		// 经过装饰（增强）后，增加了actionOnLand方法的能力
		superAnimal.actionOnLand();
		superAnimal.eatFood();
		superAnimal.sleep();
	}
}

interface Animal {
	void actionOnLand();
	void eatFood();
	void sleep();
}

class Chicken implements Animal {

	@Override
	public void actionOnLand() {
		System.out.println("在陆地行动");
	}

	@Override
	public void eatFood() {
		System.out.println("进食");
	}

	@Override
	public void sleep() {
		System.out.println("睡觉");
	}
}

/**
 * 定义抽象装饰器类
 */
abstract class SuperAnimal implements Animal {
	private Animal animal;

	public SuperAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public void actionOnLand() {
		animal.actionOnLand();
	}

	@Override
	public void eatFood() {
		animal.eatFood();
	}

	@Override
	public void sleep() {
		animal.sleep();
	}
}

/**
 * 采用继承抽象类的方式，只需要重写需要修改的方法，不需要重写所有的方法
 */
class SuperChecken extends SuperAnimal {

	public SuperChecken(Animal animal) {
		super(animal);
	}

	public void flyInSky() {
		System.out.println("在天上飞");
	}

	@Override
	public void actionOnLand() {
		super.actionOnLand();
		flyInSky();
	}
}