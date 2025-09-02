import java.util.Scanner;

public class CanVoteOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 10;
        int[] ages = new int[size];
        System.out.println("Enter the ages of 10 individuals:");
        for (int i = 0; i < size; i++) {
            ages[i] = scanner.nextInt();
        }
        System.out.println("Voting Eligibility:");
        for (int age : ages) {
            if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote");
            } else {
                System.out.println("The student with the age " + age + " cannot vote");
            }
        }
    }
}