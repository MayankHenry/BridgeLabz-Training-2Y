public class GradeCalculator {
    public double calculateAverage(Student s) {
        return s.getAverage();
    }
    public String calculateGrade(Student s) {
        double avg = calculateAverage(s);
        if(avg >= 90) return "A";
        if(avg >= 75) return "B";
        if(avg >= 60) return "C";
        return "D";
    }
    // Example interaction method
    public String requestGrade(Student s) {
        return calculateGrade(s);
    }
}