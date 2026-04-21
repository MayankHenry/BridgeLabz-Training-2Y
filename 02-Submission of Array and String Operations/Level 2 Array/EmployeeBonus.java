import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Employee " + (i + 1) + " salary: ");
            salary[i] = sc.nextDouble();
            
            if (salary[i] < 0) {
                System.out.println("Invalid salary. Enter again.");
                i--;
                continue;
            }
            
            System.out.print("Employee " + (i + 1) + " years of service: ");
            yearsOfService[i] = sc.nextDouble();
            
            if (yearsOfService[i] < 0) {
                System.out.println("Invalid years of service. Enter again.");
                i--;
                continue;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            
            newSalary[i] = salary[i] + bonus[i];
            
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        
        System.out.println("\nTotal old salary: " + totalOldSalary);
        System.out.println("Total bonus: " + totalBonus);
        System.out.println("Total new salary: " + totalNewSalary);
        
        sc.close();
    }
}
