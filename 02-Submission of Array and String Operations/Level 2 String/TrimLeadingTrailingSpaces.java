import java.util.Scanner;

public class TrimLeadingTrailingSpaces {
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    static int[] findTrimIndexes(String text) {
        int len = findLength(text);
        int start = 0;
        int end = len - 1;
        
        while (start < len && text.charAt(start) == ' ') {
            start++;
        }
        
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }
        
        return new int[]{start, end + 1};
    }
    
    static String createSubstring(String text, int startIndex, int endIndex) {
        String result = "";
        for (int i = startIndex; i < endIndex; i++) {
            result += text.charAt(i);
        }
        return result;
    }
    
    static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        int[] indexes = findTrimIndexes(text);
        String userDefined = createSubstring(text, indexes[0], indexes[1]);
        String builtin = text.trim();
        
        boolean result = compareStrings(userDefined, builtin);
        
        System.out.println("User-defined trim: '" + userDefined + "'");
        System.out.println("Built-in trim(): '" + builtin + "'");
        System.out.println("Results are equal: " + result);
        
        sc.close();
    }
}
