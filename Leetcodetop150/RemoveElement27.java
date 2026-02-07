import java.util.*;

public class RemoveElement27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Read array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read value to remove
        int val = sc.nextInt();

        // Call method
        int k = removeElement(nums, val);

        // Print result
        System.out.println(k);

        // Print modified array (only valid part)
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // Same logic as your Solution class
    public static int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
