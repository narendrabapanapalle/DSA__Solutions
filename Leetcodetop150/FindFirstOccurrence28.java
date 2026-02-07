import java.util.*;

class FindFirstOccurrence28 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter haystack string: ");
        String haystack = sc.nextLine();

        System.out.print("Enter needle string: ");
        String needle = sc.nextLine();

        int index = strStr(haystack, needle);

        System.out.println("Index: " + index);
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
