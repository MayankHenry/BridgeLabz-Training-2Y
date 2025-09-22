interface IApprovable {
    boolean approveLoan();
    double calculateEMI();
}

class Applicant {
    private String name;
    private int creditScore;
    private double income, loanAmount;

    Applicant(String n, int cs, double inc, double loan){
        name=n; creditScore=cs; income=inc; loanAmount=loan;
    }

    public double getIncome(){ return income; }
    public double getLoanAmount(){ return loanAmount; }
    protected int getCreditScore(){ return creditScore; } // encapsulated
    public String getName(){ return name; }
}

abstract class LoanApplication implements IApprovable {
    protected Applicant applicant;
    protected int termMonths;
    protected double interestRate;
    private String status="Pending"; // internal only

    LoanApplication(Applicant a, int term, double rate){
        applicant=a; termMonths=term; interestRate=rate;
    }

    protected void setStatus(String s){ status=s; }
    public String getStatus(){ return status; }
    public abstract double calculateEMI();
    public abstract boolean approveLoan();
}

class HomeLoan extends LoanApplication {
    HomeLoan(Applicant a,int term,double rate){ super(a,term,rate); }

    public double calculateEMI(){
        double P=applicant.getLoanAmount();
        double R=interestRate/12/100;
        int N=termMonths;
        return P*R*Math.pow(1+R,N)/(Math.pow(1+R,N)-1);
    }

    public boolean approveLoan(){
        if(applicant.getCreditScore()>=700 && applicant.getIncome()*0.5>=applicant.getLoanAmount()/termMonths){
            setStatus("Approved"); return true;
        } else { setStatus("Rejected"); return false; }
    }
}

class AutoLoan extends LoanApplication {
    AutoLoan(Applicant a,int term,double rate){ super(a,term,rate); }

    public double calculateEMI(){
        double P=applicant.getLoanAmount();
        double R=interestRate/12/100;
        int N=termMonths;
        return P*R*Math.pow(1+R,N)/(Math.pow(1+R,N)-1)*0.95; // 5% processing fee reduction
    }

    public boolean approveLoan(){
        if(applicant.getCreditScore()>=650 && applicant.getIncome()*0.4>=applicant.getLoanAmount()/termMonths){
            setStatus("Approved"); return true;
        } else { setStatus("Rejected"); return false; }
    }
}

public class LoanBuddyApp {
    public static void main(String[] args){
        Applicant a1=new Applicant("Amit",720,100000,500000);
        LoanApplication homeLoan=new HomeLoan(a1,60,7.5);

        System.out.println("Loan Applicant: "+a1.getName());
        homeLoan.approveLoan();
        System.out.println("Loan Status: "+homeLoan.getStatus());
        System.out.println("Monthly EMI: "+homeLoan.calculateEMI());

        Applicant a2=new Applicant("Riya",680,80000,300000);
        LoanApplication autoLoan=new AutoLoan(a2,36,9);

        autoLoan.approveLoan();
        System.out.println("\nLoan Applicant: "+a2.getName());
        System.out.println("Loan Status: "+autoLoan.getStatus());
        System.out.println("Monthly EMI: "+autoLoan.calculateEMI());
    }
}
