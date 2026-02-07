import java.util.*;

public class RotateArray189 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Read array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read k
        int k = sc.nextInt();

        rotate(nums, k);

        // Print rotated array
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }

    // In-place rotation using reverse
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k > n

        // Step 1: reverse whole array
        reverse(nums, 0, n - 1);

        // Step 2: reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: reverse remaining elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
