import java.util.Scanner;

class ShortestLongestWord {
    public static String[] splitWords(String s) {
        int count = 1;
        for (int i = 0;; i++) {
            try {
                if (s.charAt(i) == ' ')
                    count++;
            } catch (Exception e) {
                break;
            }
        }
        String[] arr = new String[count];
        int idx = 0;
        String temp = "";
        for (int i = 0;; i++) {
            char ch;
            try {
                ch = s.charAt(i);
            } catch (Exception e) {
                arr[idx] = temp;
                break;
            }
            if (ch == ' ') {
                arr[idx] = temp;
                temp = "";
                idx++;
            } else {
                temp += ch;
            }
        }
        return arr;
    }
    public static int myLength(String s) {
        int n = 0;
        try {
            for (;;) {
                s.charAt(n);
                n++;
            }
        } catch (Exception e) {}
        return n;
    }
    public static String[][] to2D(String[] words) {
        String[][] a = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            a[i][0] = words[i];
            a[i][1] = String.valueOf(myLength(words[i]));
        }
        return a;
    }
    public static int[] findMinMax(String[][] arr) {
        int min = Integer.parseInt(arr[0][1]);
        int max = min;
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            int val = Integer.parseInt(arr[i][1]);
            if (val < min) {
                min = val;
                minIdx = i;
            }
            if (val > max) {
                max = val;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String[] words = splitWords(t);
        String[][] wordLens = to2D(words);
        int[] minmax = findMinMax(wordLens);
        System.out.println("Shortest: " + wordLens[minmax[0]][0]);
        System.out.println("Longest: " + wordLens[minmax[1]][0]);
    }
}
