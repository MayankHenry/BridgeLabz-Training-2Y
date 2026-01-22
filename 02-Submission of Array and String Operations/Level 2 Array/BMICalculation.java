import java.util.Scanner;

public class BMICalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        
        System.out.println("Enter weight and height for each person:");
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            weight[i] = sc.nextDouble();
            
            System.out.print("Person " + (i + 1) + " height (m): ");
            height[i] = sc.nextDouble();
        }
        
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 25) {
                status[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        
        System.out.println("\nBMI Report:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + height[i] + ", Weight=" + weight[i] + ", BMI=" + bmi[i] + ", Status=" + status[i]);
        }
        
        sc.close();
    }
}
