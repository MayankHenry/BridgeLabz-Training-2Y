import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        String[] grade = new String[n];
        
        System.out.println("Enter marks for physics, chemistry, and maths:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " physics: ");
            physics[i] = sc.nextDouble();
            if (physics[i] < 0) {
                System.out.println("Enter positive marks");
                i--;
                continue;
            }
            
            System.out.print("Student " + (i + 1) + " chemistry: ");
            chemistry[i] = sc.nextDouble();
            if (chemistry[i] < 0) {
                System.out.println("Enter positive marks");
                i--;
                continue;
            }
            
            System.out.print("Student " + (i + 1) + " maths: ");
            maths[i] = sc.nextDouble();
            if (maths[i] < 0) {
                System.out.println("Enter positive marks");
                i--;
                continue;
            }
        }
        
        for (int i = 0; i < n; i++) {
            double total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3;
            
            if (percentage[i] >= 90) {
                grade[i] = "A";
            } else if (percentage[i] >= 80) {
                grade[i] = "B";
            } else if (percentage[i] >= 70) {
                grade[i] = "C";
            } else if (percentage[i] >= 60) {
                grade[i] = "D";
            } else {
                grade[i] = "F";
            }
        }
        
        System.out.println("\nStudent Report:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Physics=" + physics[i] + ", Chemistry=" + chemistry[i] + ", Maths=" + maths[i] + ", Percentage=" + percentage[i] + ", Grade=" + grade[i]);
        }
        
        sc.close();
    }
}
