interface ICertifiable {
    void generateCertificate();
}

class User {
    protected String name, email;
    protected int userId;
    User(String n, String e, int id){ name=n; email=e; userId=id; }
}

class Learner extends User implements ICertifiable {
    Learner(String n,String e,int id){ super(n,e,id); }
    public void generateCertificate(){
        System.out.println("Certificate for Learner "+name+" (Short Course)");
    }
}

class Instructor extends User implements ICertifiable {
    Instructor(String n,String e,int id){ super(n,e,id); }
    public void generateCertificate(){
        System.out.println("Certificate for Instructor "+name+" (Full-time Course)");
    }
}

class Quiz {
    private String[] questions;
    private String[] answers;
    private int score=0;

    Quiz(String[] qs, String[] ans){
        questions=qs; answers=ans; // encapsulated answers
    }

    public void takeQuiz(String[] userAnswers){
        for(int i=0;i<answers.length;i++){
            if(i<userAnswers.length && answers[i].equalsIgnoreCase(userAnswers[i]))
                score++;
        }
    }

    public double getPercentage(){
        return (double)score/answers.length*100; // operator usage
    }

    public void showResult(){
        System.out.println("Score: "+score+"/"+answers.length+" Percentage: "+getPercentage()+"%");
    }
}

public class EduMentorApp {
    public static void main(String[] args){
        Learner l=new Learner("Amit","amit@mail.com",101);
        Instructor ins=new Instructor("Dr.Mehta","mehta@mail.com",201);

        String[] qs={"Q1","Q2","Q3"};
        String[] ans={"A","B","C"};
        Quiz quiz=new Quiz(qs,ans);

        String[] userAns={"A","B","C"};
        quiz.takeQuiz(userAns);
        quiz.showResult();

        l.generateCertificate();
        ins.generateCertificate();
    }
}
