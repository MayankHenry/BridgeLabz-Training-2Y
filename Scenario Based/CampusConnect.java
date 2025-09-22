interface ICourseActions {
    void enrollCourse(Course c);
    void dropCourse(Course c);
}

class Person {
    protected String name, email;
    protected int id;
    Person(String n, String e, int i){ name=n; email=e; id=i; }
    void printDetails(){ System.out.println("ID:"+id+" Name:"+name+" Email:"+email); }
}

class Student extends Person implements ICourseActions {
    private double[] grades = new double[10];
    private int gradeCount=0;
    private Course[] courses = new Course[10];
    private int courseCount=0;

    Student(String n, String e, int i){ super(n,e,i); }

    public void enrollCourse(Course c){
        if(courseCount<10) { courses[courseCount++] = c; c.addStudent(this); }
    }

    public void dropCourse(Course c){
        for(int i=0;i<courseCount;i++){
            if(courses[i]==c){
                for(int j=i;j<courseCount-1;j++) courses[j]=courses[j+1];
                courseCount--; break;
            }
        }
    }

    public void addGrade(double g){ if(gradeCount<10) grades[gradeCount++]=g; }

    public double calculateGPA(){
        double sum=0;
        for(int i=0;i<gradeCount;i++) sum+=grades[i];
        return gradeCount>0 ? sum/gradeCount : 0;
    }

    @Override
    void printDetails(){
        System.out.println("Student ID:"+id+" Name:"+name+" GPA:"+calculateGPA());
    }
}

class Faculty extends Person {
    private Course courseAssigned;
    Faculty(String n,String e,int i){ super(n,e,i); }
    void assignCourse(Course c){ courseAssigned=c; c.setFaculty(this); }
    @Override
    void printDetails(){
        System.out.println("Faculty ID:"+id+" Name:"+name+" Teaches:"+ (courseAssigned!=null ? courseAssigned.getName():"None"));
    }
}

class Course {
    private String name;
    private Student[] students = new Student[10];
    private int studentCount=0;
    private Faculty faculty;

    Course(String n){ name=n; }

    void addStudent(Student s){ if(studentCount<10) students[studentCount++]=s; }
    void setFaculty(Faculty f){ faculty=f; }
    String getName(){ return name; }
}

public class CampusConnect {
    public static void main(String[] args){
        Student s1=new Student("Amit","amit@mail.com",101);
        Student s2=new Student("Riya","riya@mail.com",102);
        Faculty f1=new Faculty("Dr.Mehta","mehta@mail.com",201);

        Course c1=new Course("OOP");
        Course c2=new Course("DataStructures");

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);

        s1.addGrade(9);
        s1.addGrade(8.5);
        s2.addGrade(8);

        f1.assignCourse(c1);

        s1.printDetails();
        s2.printDetails();
        f1.printDetails();
    }
}
