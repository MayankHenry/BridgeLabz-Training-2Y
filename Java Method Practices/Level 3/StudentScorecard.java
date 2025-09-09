import java.util.Random;

public class StudentScorecard {
    public static void main(String[] args) {
        int numberOfStudents = 5;
        int[][] marks = new int[numberOfStudents][3];
        Random random = new Random();

        for (int i = 0; i < numberOfStudents; i++) {
            marks[i][0] = 10 + random.nextInt(91); // Physics
            marks[i][1] = 10 + random.nextInt(91); // Chemistry
            marks[i][2] = 10 + random.nextInt(91); // Maths
        }

        System.out.println("--- Student Scorecard ---");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", 
                          "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage");

        for (int i = 0; i < numberOfStudents; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = (double) total / 3.0;
            double percentage = average;

            System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10.2f %-10.2f%%\n",
                              (i + 1), marks[i][0], marks[i][1], marks[i][2], total, average, percentage);
        }
    }
}