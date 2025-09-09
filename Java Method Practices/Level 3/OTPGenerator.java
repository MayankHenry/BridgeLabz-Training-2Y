import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class OTPGenerator {

    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> uniqueOTPs = new HashSet<>();
        
        System.out.println("Generating 10 unique 6-digit OTPs...");

        while (uniqueOTPs.size() < 10) {
            int otp = 100000 + random.nextInt(900000);
            uniqueOTPs.add(otp);
        }

        int count = 1;
        for (int otp : uniqueOTPs) {
            System.out.println("OTP " + count++ + ": " + otp);
        }

        System.out.println("\nAll 10 generated OTPs are unique.");
    }
}