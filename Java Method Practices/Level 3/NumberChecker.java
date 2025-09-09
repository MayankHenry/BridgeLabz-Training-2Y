import java.util.Arrays;

public class NumberChecker {

    private static int[] getDigits(int number) {
        String s = Integer.toString(Math.abs(number));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuckNumber(int number) {
        String s = Integer.toString(number);
        return s.indexOf('0') != -1 && s.charAt(0) != '0';
    }

    public static boolean isArmstrong(int number) {
        if (number < 0) return false;
        int[] digits = getDigits(number);
        int n = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, n);
        }
        return sum == number;
    }
    
    public static boolean isHarshad(int number) {
        if (number <= 0) return false;
        int[] digits = getDigits(number);
        int sum = 0;
        for(int digit : digits) {
            sum += digit;
        }
        return number % sum == 0;
    }

    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    public static boolean isNeon(int number) {
        if (number < 0) return false;
        int square = number * number;
        int sumOfDigits = 0;
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }

    public static boolean isSpy(int number) {
        int[] digits = getDigits(number);
        int sum = 0;
        int product = 1;
        for(int digit : digits) {
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }
    
    public static boolean isAutomorphic(int number) {
        long square = (long) number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }
    
    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
    
    public static boolean isPerfect(int number) {
        if (number < 1) return false;
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
    
    public static boolean isStrong(int number) {
        int original = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            int fact = 1;
            for(int i = 1; i <= digit; i++) {
                fact *= i;
            }
            sum += fact;
            number /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) {
        int testNum = 153;
        System.out.println("Testing number: " + testNum);
        System.out.println("Is Armstrong? " + isArmstrong(testNum));
        System.out.println("Is Palindrome? " + isPalindrome(testNum));
        System.out.println("Is Prime? " + isPrime(testNum));
        System.out.println("Is Perfect? " + isPerfect(testNum));
        System.out.println("Is Strong? " + isStrong(145));
        System.out.println("Is Duck? " + isDuckNumber(1023));
        System.out.println("Is Harshad? " + isHarshad(21));
        System.out.println("Is Neon? " + isNeon(9));
        System.out.println("Is Spy? " + isSpy(123));
        System.out.println("Is Automorphic? " + isAutomorphic(25));
        System.out.println("Is Buzz? " + isBuzz(49));
    }
}