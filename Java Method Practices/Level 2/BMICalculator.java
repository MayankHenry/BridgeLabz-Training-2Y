import java.util.Scanner;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 39.9) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] teamData = new double[10][2]; // col 0: weight, col 1: height

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            teamData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            teamData[i][1] = scanner.nextDouble();
        }

        System.out.println("\n--- BMI Results ---");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s\n", "Person", "Weight(kg)", "Height(cm)", "BMI", "Status");
        
        for (int i = 0; i < 10; i++) {
            double weight = teamData[i][0];
            double heightInMeters = teamData[i][1] / 100.0;
            double bmi = weight / (heightInMeters * heightInMeters);
            String status = getBmiStatus(bmi);
            
            System.out.printf("%-10d %-10.1f %-10.1f %-10.2f %-15s\n", (i+1), weight, teamData[i][1], bmi, status);
        }
        scanner.close();
    }
}