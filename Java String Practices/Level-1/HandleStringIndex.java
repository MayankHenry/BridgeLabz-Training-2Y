import java.util.Scanner;

public class HandleStringIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter an index to access: ");
        int index = scanner.nextInt();
        scanner.close();
        try {
            char ch = str.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught a StringIndexOutOfBoundsException: Invalid index " + index);
        }
    }
}
