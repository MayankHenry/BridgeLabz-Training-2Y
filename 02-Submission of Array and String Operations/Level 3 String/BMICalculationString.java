import java.util.Scanner;

public class BMICalculationString {
    static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);
            
            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status = "Normal weight";
            } else if (bmi >= 25 && bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            
            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        
        return result;
    }
    
    static void displayTable(String[][] data) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("---------\t---------\t----\t-----------");
        
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        
        double[][] data = new double[n][2];
        
        System.out.println("Enter weight (kg) and height (cm):");
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " weight: ");
            data[i][0] = sc.nextDouble();
            
            System.out.print("Person " + (i + 1) + " height (cm): ");
            data[i][1] = sc.nextDouble();
        }
        
        String[][] bmiData = calculateBMI(data);
        displayTable(bmiData);
        
        sc.close();
    }
}
