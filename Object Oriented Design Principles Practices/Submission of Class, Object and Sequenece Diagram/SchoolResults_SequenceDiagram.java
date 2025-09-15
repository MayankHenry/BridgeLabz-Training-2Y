class SD_Student {
	private String name;
	public SD_Student(String name) { this.name = name; }
	public String getName() { return name; }
	public String requestGrade(SD_GradeCalculator gc) { return gc.calculate(this); }
}

class SD_GradeCalculator {
	public String calculate(SD_Student s) { return "A"; }
}

public class SchoolResults_SequenceDiagram {
	public static void main(String[] args) {
		SD_Student student = new SD_Student("John");
		SD_GradeCalculator gc = new SD_GradeCalculator();
		System.out.println("Student -> GradeCalculator: requestGrade()");
		String grade = student.requestGrade(gc);
		System.out.println("GradeCalculator --> Student: " + grade);
	}
}
