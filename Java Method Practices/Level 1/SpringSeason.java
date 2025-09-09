import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        
        System.out.print("Enter day (1-31): ");
        int day = sc.nextInt();
        
        boolean isSpring = isSpringDay(month, day);
        
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
        
        sc.close();
    }
    
    static boolean isSpringDay(int month, int day) {
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }
}