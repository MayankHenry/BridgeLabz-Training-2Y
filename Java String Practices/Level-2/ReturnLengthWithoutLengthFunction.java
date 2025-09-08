import java.util.Scanner;

public class ReturnLengthWithoutLengthFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        int length = 0;
        try {
            while(true){
                str.charAt(length);
                length++;
            }
        } catch(StringIndexOutOfBoundsException e){
        }
        System.out.println("Length of the string: " + length);
    }    
}
