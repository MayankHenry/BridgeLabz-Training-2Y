import java.util.Random;

public class StudentScorecard {
    static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 + rand.nextInt(60);
            scores[i][1] = 40 + rand.nextInt(60);
            scores[i][2] = 40 + rand.nextInt(60);
        }
        
        return scores;
    }
    
    static double[][] calculateTotalAveragePercentage(int[][] scores) {
        double[][] result = new double[scores.length][3];
        
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            
            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        
        return result;
    }
    
    static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        
        for (int i = 0; i < stats.length; i++) {
            double percentage = stats[i][2];
            
            if (percentage >= 90) {
                grades[i] = "A";
            } else if (percentage >= 80) {
                grades[i] = "B";
            } else if (percentage >= 70) {
                grades[i] = "C";
            } else if (percentage >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }
        
        return grades;
    }
    
    static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("-------\t-------\t---------\t-----\t-----\t-------\t----------\t-----");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + 
                             "\t" + (int)stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "%\t\t" + grades[i]);
        }
    }
    
    public static void main(String[] args) {
        int numStudents = 5;
        
        int[][] scores = generateScores(numStudents);
        double[][] stats = calculateTotalAveragePercentage(scores);
        String[] grades = calculateGrades(stats);
        
        displayScorecard(scores, stats, grades);
    }
}
