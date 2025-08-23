import java.util.Scanner;

public class BonusOfEmployeesYearsMoreThan5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of years the employee has worked: ");
        int yearsWorked = scanner.nextInt();
        double salary = scanner.nextDouble();
        if (yearsWorked > 5) {
            double bonus = salary * 0.05;
            System.out.println("The bonus for the employee is: " + bonus);
        } else {
            System.out.println("No bonus awarded. The employee has not worked more than 5 years.");
        }
        scanner.close();
    }

}
