public class LinearSearchNegativeNumber {
    static int searchNegativeNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, -3, 20, -8};
        
        int index = searchNegativeNumber(arr);
        
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
            System.out.println("Value: " + arr[index]);
        } else {
            System.out.println("No negative number found");
        }
    }
}
