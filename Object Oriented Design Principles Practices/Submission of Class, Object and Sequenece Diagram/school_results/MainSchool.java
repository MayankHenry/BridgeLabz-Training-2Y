public class MainSchool {
    public static void main(String[] args) {
        Student john = new Student("John", 12);
        Subject maths = new Subject("Maths", 90);
        Subject science = new Subject("Science", 85);
        john.addSubject(maths); john.addSubject(science);
        GradeCalculator calc = new GradeCalculator();
        System.out.println("Average: " + calc.calculateAverage(john));
        System.out.println("Grade: " + calc.calculateGrade(john));
    }
}