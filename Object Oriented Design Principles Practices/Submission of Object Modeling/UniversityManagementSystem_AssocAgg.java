import java.util.*;

class UniCourse {
	private String name;
	private Professor professor;
	private Set<UniStudent> students = new HashSet<>();

	public UniCourse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void assignProfessor(Professor p) {
		this.professor = p;
	}

	public void enroll(UniStudent s) {
		students.add(s);
	}

	public void show() {
		System.out.println("Course: " + name);
		System.out.println("Professor: " + (professor == null ? "TBD" : professor.getName()));
		System.out.println("Students:");
		for (UniStudent s : students) System.out.println(s.getName());
	}
}

class UniStudent {
	private String name;
	private Set<UniCourse> courses = new HashSet<>();

	public UniStudent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void enrollCourse(UniCourse c) {
		courses.add(c);
		c.enroll(this);
	}
}

class Professor {
	private String name;

	public Professor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class UniversityMgmt {
	private String name;
	private List<UniStudent> students = new ArrayList<>();

	public UniversityMgmt(String name) {
		this.name = name;
	}

	public void addStudent(UniStudent s) {
		students.add(s);
	}
}

public class UniversityManagementSystem_AssocAgg {
	public static void main(String[] args) {
		UniversityMgmt uni = new UniversityMgmt("City University");
		UniStudent s1 = new UniStudent("Kiran");
		UniStudent s2 = new UniStudent("Maya");
		Professor pr = new Professor("Dr. Iyer");
		UniCourse c1 = new UniCourse("Data Structures");
		c1.assignProfessor(pr);
		s1.enrollCourse(c1);
		s2.enrollCourse(c1);
		uni.addStudent(s1);
		uni.addStudent(s2);
		c1.show();
	}
}
