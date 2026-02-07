import java.util.*;

public class ProductofArrayExceptSelf238  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Read array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call method
        int[] result = productExceptSelf(nums);

        // Print result array
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    // Your logic (unchanged)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n]; // prefix products
        int[] arr2 = new int[n]; // suffix products
        int[] ans  = new int[n];

        arr1[0] = 1;
        arr2[n - 1] = 1;

        // Build prefix product array
        for (int i = 1; i < n; i++) {
            arr1[i] = arr1[i - 1] * nums[i - 1];
        }

        // Build suffix product array
        for (int i = n - 2; i >= 0; i--) {
            arr2[i] = arr2[i + 1] * nums[i + 1];
        }

        // Build answer
        for (int i = 0; i < n; i++) {
            ans[i] = arr1[i] * arr2[i];
        }

        return ans;
    }
}
