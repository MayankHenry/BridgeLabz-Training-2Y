
import java.util.Scanner;

public class CalculatePenDivisin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of pens: ");
        int pens = sc.nextInt();
        System.out.print("Enter the number of people: ");
        int people = sc.nextInt();
        if (people == 0) {
            System.out.println("Cannot divide by zero.");
        } else {
            int pensPerPerson = pens / people;
            int remainingPens = pens % people;
            System.out.println("The Pen Per Student is " + pensPerPerson + " and the remaining pen not distributed is " + remainingPens);
        }
    }
}
