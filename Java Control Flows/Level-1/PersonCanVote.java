public class PersonCanVote {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        if (age >= 18) {
            System.out.println("The Person's age is: " + age+ " and can vote.");
        } else {
            System.out.println("The Person's age is: " + age+ " and cannot vote.");
        }
        
        scanner.close();
    }
}
