public class NullPointerExceptionDemo {
    static void generateNullPointerException() {
        String text = null;
        System.out.println(text.length());
    }
    
    static void handleNullPointerException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Cannot call method on null reference");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Generating NullPointerException:");
        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception generated: " + e.getClass().getName());
        }
        
        System.out.println("\nHandling NullPointerException:");
        handleNullPointerException();
    }
}
