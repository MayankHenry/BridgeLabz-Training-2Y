public class BinarySearchPeakElement {
    static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        
        int index = findPeakElement(arr);
        
        System.out.println("Peak element found at index: " + index);
        System.out.println("Peak element value: " + arr[index]);
    }
}
