import java.util.Scanner;

public class BMICalculator {
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1] / 100.0;
            double bmi = weight / (height * height);
            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Overweight";
            else status = "Obese";
            
            result[i][0] = String.valueOf(data[i][1]);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }
    
    public static void displayTable(String[][] data) {
        System.out.println("Height  Weight  BMI     Status");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%6s  %6s  %6s  %s\n", data[i][0], data[i][1], data[i][2], data[i][3]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight and height for person " + (i+1) + ": ");
            data[i][0] = sc.nextDouble();
            data[i][1] = sc.nextDouble();
        }
        String[][] result = calculateBMI(data);
        displayTable(result);
    }
}
