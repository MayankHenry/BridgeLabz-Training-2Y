import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10];

        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }

        System.out.println("\n--- Voting Eligibility ---");
        for (int i = 0; i < studentAges.length; i++) {
            if (canStudentVote(studentAges[i])) {
                System.out.println("Student " + (i + 1) + " (Age " + studentAges[i] + ") can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " (Age " + studentAges[i] + ") cannot vote.");
            }
        }
        scanner.close();
    }
}