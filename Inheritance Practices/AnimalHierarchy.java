public class AnimalHierarchy {
	public static void main(String[] args) {
		Animal a1 = new Dog("Buddy", 3);
		Animal a2 = new Cat("Misty", 2);
		Animal a3 = new Bird("Sky", 1);

		Animal[] animals = {a1, a2, a3};
		for (Animal a : animals) {
			System.out.println(a.name + " (" + a.age + ")" + ": ");
			a.makeSound();
		}
	}
}

class Animal {
	String name;
	int age;

	Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void makeSound() {
		System.out.println("Animal makes a sound");
	}
}

class Dog extends Animal {
	Dog(String name, int age) {
		super(name, age);
	}

	@Override
	void makeSound() {
		System.out.println("Bark");
	}
}

class Cat extends Animal {
	Cat(String name, int age) {
		super(name, age);
	}

	@Override
	void makeSound() {
		System.out.println("Meow");
	}
}

class Bird extends Animal {
	Bird(String name, int age) {
		super(name, age);
	}

	@Override
	void makeSound() {
		System.out.println("Chirp");
	}
}
