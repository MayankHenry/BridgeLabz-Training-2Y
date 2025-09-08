import java.util.Scanner;

public class TrimSpacesCharAt {
    public static int[] findEdges(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') start++;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String mySubstring(String s, int st, int en) {
        String r = "";
        for (int i = st; i <= en; i++) r += s.charAt(i);
        return r;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        int[] edges = findEdges(t);
        String trimmed;
        if (edges[0] > edges[1]) trimmed = ""; // Only spaces
        else trimmed = mySubstring(t, edges[0], edges[1]);
        String builtin = t.trim();
        boolean isSame = compareStrings(trimmed, builtin);
        System.out.println("Trimmed: '" + trimmed + "'");
        System.out.println("Built-in: '" + builtin + "'");
        System.out.println("Match: " + isSame);
    }
}
