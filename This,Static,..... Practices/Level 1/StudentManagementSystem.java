public class StudentManagementSystem {
    public static void main(String[] args) {
        Student.universityName = "National University";
        Student s1 = new Student("Nina", 301, "A");
        Object ref = s1;
        if (ref instanceof Student) {
            ((Student) ref).show();
        }
        Student.displayTotalStudents();
    }
}

class Student {
    static String universityName;
    private static int totalStudents;
    final int rollNumber;
    String name;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void show() {
        System.out.println("University: " + universityName + ", Name: " + name + ", Roll: " + rollNumber + ", Grade: " + grade);
    }
}


