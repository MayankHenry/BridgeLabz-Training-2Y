public class PalindromeChecker {
    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        int length = cleanText.length();
        
        for (int i = 0; i < length / 2; i++) {
            if (cleanText.charAt(i) != cleanText.charAt(length - 1 - i)) {
                return false;
            }
        }
        
        return true;
    }

    public void displayResult() {
        System.out.println("Text: " + text);
        if (isPalindrome()) {
            System.out.println("The text is a palindrome.");
        } else {
            System.out.println("The text is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("radar");
        checker1.displayResult();
        
        PalindromeChecker checker2 = new PalindromeChecker("hello");
        checker2.displayResult();
        
        PalindromeChecker checker3 = new PalindromeChecker("A man a plan a canal Panama");
        checker3.displayResult();
    }
}