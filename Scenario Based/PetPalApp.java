interface IInteractable {
    void feed();
    void play();
    void sleep();
}

abstract class Pet implements IInteractable {
    protected String name, type;
    protected int age;
    private int hunger=50; // 0-100
    private int mood=50;   // 0-100

    Pet(String n, String t, int a){ name=n; type=t; age=a; }

    protected void changeHunger(int val){ hunger += val; if(hunger<0) hunger=0; if(hunger>100) hunger=100; }
    protected void changeMood(int val){ mood += val; if(mood<0) mood=0; if(mood>100) mood=100; }

    abstract void makeSound();
    public void status(){ System.out.println(name+" Hunger:"+hunger+" Mood:"+mood); }
}

class Dog extends Pet {
    Dog(String n,int a){ super(n,"Dog",a); }
    public void feed(){ changeHunger(-20); changeMood(10); System.out.println(name+" is fed."); }
    public void play(){ changeMood(15); changeHunger(10); System.out.println(name+" is playing."); }
    public void sleep(){ changeMood(5); changeHunger(5); System.out.println(name+" is sleeping."); }
    void makeSound(){ System.out.println(name+" says: Woof!"); }
}

class Cat extends Pet {
    Cat(String n,int a){ super(n,"Cat",a); }
    public void feed(){ changeHunger(-15); changeMood(10); System.out.println(name+" is fed."); }
    public void play(){ changeMood(20); changeHunger(10); System.out.println(name+" is playing."); }
    public void sleep(){ changeMood(5); changeHunger(5); System.out.println(name+" is sleeping."); }
    void makeSound(){ System.out.println(name+" says: Meow!"); }
}

class Bird extends Pet {
    Bird(String n,int a){ super(n,"Bird",a); }
    public void feed(){ changeHunger(-10); changeMood(10); System.out.println(name+" is fed."); }
    public void play(){ changeMood(15); changeHunger(5); System.out.println(name+" is playing."); }
    public void sleep(){ changeMood(5); changeHunger(2); System.out.println(name+" is sleeping."); }
    void makeSound(){ System.out.println(name+" says: Tweet!"); }
}

public class PetPalApp {
    public static void main(String[] args){
        Pet d=new Dog("Buddy",3);
        Pet c=new Cat("Kitty",2);
        Pet b=new Bird("Tweety",1);

        d.feed(); d.play(); d.sleep(); d.makeSound(); d.status();
        c.feed(); c.play(); c.sleep(); c.makeSound(); c.status();
        b.feed(); b.play(); b.sleep(); b.makeSound(); b.status();
    }
}
