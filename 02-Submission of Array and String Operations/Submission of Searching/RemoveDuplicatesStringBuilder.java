import java.util.HashSet;

public class RemoveDuplicatesStringBuilder {
    static String removeDuplicates(String text) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String text = "programming";
        
        String result = removeDuplicates(text);
        
        System.out.println("Original: " + text);
        System.out.println("Without duplicates: " + result);
    }
}
