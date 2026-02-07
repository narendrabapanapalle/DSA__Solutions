import java.util.*;

public class RemoveDuplicatesSortedArray26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Read sorted array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = removeDuplicates(nums);

        // Print number of unique elements
        System.out.println(k);

        // Print the first k elements
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // Your logic (unchanged)
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
