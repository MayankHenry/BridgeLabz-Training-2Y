class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

public class StudentManager {
    private StudentNode head;

    public void add(int rollNumber, String name, int age, String grade, int position) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (position == 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        StudentNode current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void delete(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public StudentNode search(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) return current;
            current = current.next;
        }
        return null;
    }

    public void display() {
        StudentNode current = head;
        while (current != null) {
            System.out.println(current.rollNumber + " " + current.name + " " + current.age + " " + current.grade);
            current = current.next;
        }
    }

    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode student = search(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }
}