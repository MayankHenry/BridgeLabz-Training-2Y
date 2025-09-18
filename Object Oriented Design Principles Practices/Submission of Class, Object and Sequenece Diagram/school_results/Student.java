import java.util.ArrayList;
import java.util.List;
public class Student {
    private String name;
    private int rollNo;
    private List<Subject> subjects = new ArrayList<>();
    public Student(String name, int rollNo) { this.name = name; this.rollNo = rollNo; }
    public void addSubject(Subject s) { subjects.add(s); }
    public double getAverage() {
        if(subjects.isEmpty()) return 0;
        double sum = 0;
        for(Subject s: subjects) sum += s.getMarks();
        return sum / subjects.size();
    }
    public String getName(){ return name; }
    public List<Subject> getSubjects(){ return subjects; }
}