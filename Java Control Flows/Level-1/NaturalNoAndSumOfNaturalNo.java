import java.util.Scanner;

public class NaturalNoAndSumOfNaturalNo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        
        if (n < 1) {
            System.out.println("Please enter a natural number greater than 0.");
        } 
        else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println("The sum of n " + n + " natural numbers is: " + sum);
        }
        if(n>0){
            System.out.println("The number "+ n+ " is a natural number");
        } else {
            System.out.println("The number "+n+" is not a natural number");
        }
        
        scanner.close();
    }
}
