import java.util.Scanner;

public class BMICalculationMultiDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        
        System.out.println("Enter weight and height for each person:");
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            double w = sc.nextDouble();
            if (w <= 0) {
                System.out.println("Enter positive value");
                i--;
                continue;
            }
            personData[i][0] = w;
            
            System.out.print("Person " + (i + 1) + " height (m): ");
            double h = sc.nextDouble();
            if (h <= 0) {
                System.out.println("Enter positive value");
                i--;
                continue;
            }
            personData[i][1] = h;
        }
        
        for (int i = 0; i < n; i++) {
            double bmi = personData[i][0] / (personData[i][1] * personData[i][1]);
            personData[i][2] = bmi;
            
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\nBMI Report:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + personData[i][1] + ", Weight=" + personData[i][0] + ", BMI=" + personData[i][2] + ", Status=" + weightStatus[i]);
        }
        
        sc.close();
    }
}
