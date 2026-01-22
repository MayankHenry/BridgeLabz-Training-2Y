import java.util.Scanner;

public class StudentGradesMultiDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];
        
        System.out.println("Enter marks for physics, chemistry, and maths:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " physics: ");
            marks[i][0] = sc.nextDouble();
            if (marks[i][0] < 0) {
                System.out.println("Enter positive marks");
                i--;
                continue;
            }
            
            System.out.print("Student " + (i + 1) + " chemistry: ");
            marks[i][1] = sc.nextDouble();
            if (marks[i][1] < 0) {
                System.out.println("Enter positive marks");
                i--;
                continue;
            }
            
            System.out.print("Student " + (i + 1) + " maths: ");
            marks[i][2] = sc.nextDouble();
            if (marks[i][2] < 0) {
                System.out.println("Enter positive marks");
                i--;
                continue;
            }
        }
        
        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
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
            System.out.println("Student " + (i + 1) + ": Physics=" + marks[i][0] + ", Chemistry=" + marks[i][1] + ", Maths=" + marks[i][2] + ", Percentage=" + percentage[i] + ", Grade=" + grade[i]);
        }
        
        sc.close();
    }
}
