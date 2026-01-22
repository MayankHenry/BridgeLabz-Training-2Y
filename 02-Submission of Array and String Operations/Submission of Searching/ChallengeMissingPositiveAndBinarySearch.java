import java.util.Arrays;

public class ChallengeMissingPositiveAndBinarySearch {
    static int findFirstMissingPositive(int[] arr) {
        Arrays.sort(arr);
        int missingPositive = 1;
        
        for (int num : arr) {
            if (num == missingPositive) {
                missingPositive++;
            } else if (num > missingPositive) {
                break;
            }
        }
        
        return missingPositive;
    }
    
    static int binarySearchTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1, 5, 2};
        
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int missingPositive = findFirstMissingPositive(arr.clone());
        System.out.println("First missing positive: " + missingPositive);
        
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        int target = 4;
        int index = binarySearchTarget(arr, target);
        
        System.out.println("Searching for: " + target);
        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not found");
        }
    }
}
