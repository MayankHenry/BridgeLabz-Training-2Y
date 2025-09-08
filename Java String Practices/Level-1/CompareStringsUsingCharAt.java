import java.util.Scanner;

public class CompareStringsUsingCharAt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        scanner.close();
        int minLength = Math.min(str1.length(), str2.length());
        boolean areEqual = true;
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                areEqual = false;
                break;
            }
        }
        if (areEqual && str1.length() == str2.length()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

}