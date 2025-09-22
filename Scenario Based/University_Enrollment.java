interface Graded { void assignGrade(String courseCode,String grade); }

class Course {
    private String code; Course(String c){ code=c; }
    String getCode(){ return code; }
}

abstract class Student {
    private String name; private double gpa; private int count;
    Student(String n){ name=n; }
    Student(String n,String elective){ name=n+" (Elective:"+elective+")"; }
    void addGrade(double points){ gpa=(gpa*count+points)/(++count); }
    String getTranscript(){ return name+" GPA:"+gpa; }
}

class Undergraduate extends Student { Undergraduate(String n){ super(n); } }
class Postgraduate extends Student { Postgraduate(String n){ super(n); } }

class Faculty implements Graded {
    private String name; Faculty(String n){ name=n; }
    public void assignGrade(String c,String g){ 
        System.out.println(name+" assigned "+g+" in "+c); 
    }
}
class PassFailFaculty extends Faculty {
    PassFailFaculty(String n){ super(n); }
    public void assignGrade(String c,String g){
        System.out.println("Pass/Fail grading: "+c+" -> "+g);
    }
}

class Enrollment {
    private Student s; private Course c;
    Enrollment(Student s,Course c){ this.s=s;this.c=c; }
    String details(){ return s.getTranscript()+" enrolled "+c.getCode(); }
}

public class University_Enrollment {
    public static void main(String[] args){
        Student s1=new Undergraduate("Amit");
        Student s2=new Postgraduate("Riya");
        Course c1=new Course("CS101");
        Faculty f1=new Faculty("Dr.Mehta");
        Faculty f2=new PassFailFaculty("Dr.Verma");
        Enrollment e1=new Enrollment(s1,c1);

        System.out.println(e1.details());
        f1.assignGrade(c1.getCode(),"A");
        s1.addGrade(9);
        System.out.println(s1.getTranscript());

        f2.assignGrade(c1.getCode(),"Pass");
        s2.addGrade(8);
        System.out.println(s2.getTranscript());
    }
}
