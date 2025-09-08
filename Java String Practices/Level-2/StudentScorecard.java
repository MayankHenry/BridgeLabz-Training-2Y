import java.util.Random;

public class StudentScorecard {
    public static int[][] generateScores(int students) {
        int[][] pcm = new int[students][3];
        Random r = new Random();
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                pcm[i][j] = 10 + r.nextInt(90);
            }
        }
        return pcm;
    }
    public static double[][] getPercentages(int[][] pcm) {
        double[][] stats = new double[pcm.length][3];
        for (int i = 0; i < pcm.length; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3.0;
            double perc = Math.round((avg / 100.0) * 10000.0) / 100.0;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = perc; // percent
        }
        return stats;
    }
    public static String[] assignGrade(double[] percents) {
        String[] grades = new String[percents.length];
        for (int i = 0; i < percents.length; i++) {
            double p = percents[i];
            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else if (p >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }
    public static void showTable(int[][] pcm, double[][] stats, String[] grades) {
        System.out.println("Stu  Phy  Chem  Math  Total  Avg    %     Grade");
        for (int i = 0; i < pcm.length; i++) {
            System.out.printf("%3d  %3d   %3d   %3d   %3.0f   %4.2f  %5.2f   %s\n",
                (i+1), pcm[i][0], pcm[i][1], pcm[i][2], stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }
    public static void main(String[] args) {
        int students = 10;
        int[][] pcm = generateScores(students);
        double[][] stats = getPercentages(pcm);
        double[] percArr = new double[students];
        for (int i = 0; i < students; i++) percArr[i] = stats[i][2];
        String[] grades = assignGrade(percArr);
        showTable(pcm, stats, grades);
    }
}
