import java.util.*;

class Course {
	private String name;
	private Set<Student> students = new HashSet<>();

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void enroll(Student student) {
		students.add(student);
	}

	public void listStudents() {
		System.out.println("Course: " + name);
		for (Student s : students) {
			System.out.println(s.getName());
		}
	}
}

class Student {
	private String name;
	private Set<Course> courses = new HashSet<>();

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void enrollCourse(Course course) {
		courses.add(course);
		course.enroll(this);
	}

	public void listCourses() {
		System.out.println("Student: " + name);
		for (Course c : courses) {
			System.out.println(c.getName());
		}
	}
}

class School {
	private String name;
	private List<Student> students = new ArrayList<>();

	public School(String name) {
		this.name = name;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void listStudents() {
		System.out.println("School: " + name);
		for (Student s : students) {
			System.out.println(s.getName());
		}
	}
}

public class SchoolStudentsCourses_AssocAgg {
	public static void main(String[] args) {
		School school = new School("Greenwood High");
		Student s1 = new Student("Arjun");
		Student s2 = new Student("Leela");
		Course math = new Course("Mathematics");
		Course sci = new Course("Science");
		s1.enrollCourse(math);
		s1.enrollCourse(sci);
		s2.enrollCourse(sci);
		school.addStudent(s1);
		school.addStudent(s2);
		school.listStudents();
		System.out.println("---");
		s1.listCourses();
		System.out.println("---");
		sci.listStudents();
	}
}
