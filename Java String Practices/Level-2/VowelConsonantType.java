import java.util.Scanner;

public class VowelConsonantType {
    public static String checkChar(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] charTypes(String s) {
        String[][] res = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            res[i][0] = String.valueOf(s.charAt(i));
            res[i][1] = checkChar(s.charAt(i));
        }
        return res;
    }

    public static void printTable(String[][] data) {
        System.out.println("Character    Type");
        for (int i = 0; i < data.length; i++) {
            System.out.println("    " + data[i][0] + "        " + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String[][] res = charTypes(t);
        printTable(res);
    }
}
