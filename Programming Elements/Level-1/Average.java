
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks in Physics:");
        int physics = scanner.nextInt();
        System.out.print("Enter marks in Chemistry:");
        int chemistry = scanner.nextInt();  
        System.out.print("Enter marks in Mathematics:");
        int mathematics = scanner.nextInt();
        int average = (physics + chemistry + mathematics) / 3;
        System.out.println("Sam's Average mark in PCM is " + average);
    }
}
