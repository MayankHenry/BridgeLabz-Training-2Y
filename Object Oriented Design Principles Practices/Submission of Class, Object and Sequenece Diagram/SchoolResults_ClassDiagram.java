import java.util.*;

class Subject {
	private String name;
	private int marks;

	public Subject(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}
}

class Student {
	private String name;
	private List<Subject> subjects = new ArrayList<>();

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addSubject(Subject s) {
		subjects.add(s);
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
}

class GradeCalculator {
	public String calculateGrade(Student s) {
		int total = 0;
		for (Subject sub : s.getSubjects()) total += sub.getMarks();
		double avg = s.getSubjects().isEmpty() ? 0 : (double) total / s.getSubjects().size();
		if (avg >= 90) return "A";
		if (avg >= 75) return "B";
		if (avg >= 60) return "C";
		return "D";
	}
}

public class SchoolResults_ClassDiagram {
	public static void main(String[] args) {
		Student st = new Student("John");
		st.addSubject(new Subject("Maths", 90));
		st.addSubject(new Subject("Science", 85));
		GradeCalculator gc = new GradeCalculator();
		System.out.println(st.getName() + " Grade: " + gc.calculateGrade(st));
	}
}
