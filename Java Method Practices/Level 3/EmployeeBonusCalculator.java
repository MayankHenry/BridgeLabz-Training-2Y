import java.util.Random;

public class EmployeeBonusCalculator {

    public static void main(String[] args) {
        int[][] employees = new int[10][2]; // col 0: salary, col 1: years
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            employees[i][0] = 30000 + random.nextInt(70001); // 5-digit salary
            employees[i][1] = 1 + random.nextInt(10); // 1-10 years of service
        }

        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n", "Employee", "Old Salary", "Years", "Bonus", "New Salary");
        
        double totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            int oldSalary = employees[i][0];
            int years = employees[i][1];
            double bonus;

            if (years > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }
            
            totalBonus += bonus;
            double newSalary = oldSalary + bonus;

            System.out.printf("%-10d %-15d %-15d %-15.2f %-15.2f\n", (i+1), oldSalary, years, bonus, newSalary);
        }

        System.out.printf("\nTotal bonus to be paid by the company: %.2f\n", totalBonus);
    }
}