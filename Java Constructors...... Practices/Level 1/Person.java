public class Person {
    String name;
    int age;
    String address;
    
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.address = other.address;
    }
    
    public static void main(String[] args) {
        Person original = new Person("John Doe", 30, "123 Main St");
        Person copy = new Person(original);
        
        System.out.println("Original Person: " + original.name + ", " + original.age + ", " + original.address);
        System.out.println("Copied Person: " + copy.name + ", " + copy.age + ", " + copy.address);
        
        original.name = "Jane Doe";
        System.out.println("\nAfter changing original's name:");
        System.out.println("Original Person: " + original.name + ", " + original.age + ", " + original.address);
        System.out.println("Copied Person: " + copy.name + ", " + copy.age + ", " + copy.address);
    }
}