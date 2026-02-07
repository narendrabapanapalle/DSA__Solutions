import java.util.*;

public class IsSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read strings
        String s = sc.nextLine();
        String t = sc.nextLine();

        boolean result = isSubsequence(s, t);
        System.out.println(result);
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for s

        for (int j = 0; j < t.length(); j++) {
            if (i == s.length()) break;

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }
}
