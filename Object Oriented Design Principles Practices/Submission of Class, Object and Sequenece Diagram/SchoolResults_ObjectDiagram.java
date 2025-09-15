public class SchoolResults_ObjectDiagram {
	public static void main(String[] args) {
		String student1 = "student1:name=\"John\"";
		String subject1 = "subject1:Subject{name=\"Maths\", marks=90}";
		String subject2 = "subject2:Subject{name=\"Science\", marks=85}";
		System.out.println(student1);
		System.out.println(subject1);
		System.out.println(subject2);
		System.out.println("student1 -- has --> subject1, subject2");
	}
}
