public class ReverseStringBuilder {
    static String reverseString(String text) {
        StringBuilder sb = new StringBuilder(text);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String text = "hello";
        
        String reversed = reverseString(text);
        
        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reversed);
    }
}
