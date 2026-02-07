import java.util.*;

public class JumpGame55 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Read array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean result = canJump(nums);
        System.out.println(result);
    }

    // Your logic (unchanged)
    public static boolean canJump(int[] nums) {
        int maxInd = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current index is not reachable
            if (i > maxInd) return false;

            // Update the farthest reachable index
            maxInd = Math.max(maxInd, i + nums[i]);
        }

        return true;
    }
}
