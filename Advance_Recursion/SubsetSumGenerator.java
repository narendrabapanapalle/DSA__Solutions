import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SubsetSumGenerator {

    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // Start the recursion with index 0 and initial sum 0
        func(0, 0, nums, ans);
        return ans;
    }

    private void func(int ind, int sum, int[] nums, List<Integer> ans) {
        // Base case: if index reaches the end of the nums array
        if (ind == nums.length) {
            // Add the current sum to the ans list
            ans.add(sum);
            return;
        }

        // Recursively include the current element in the sum
        func(ind + 1, sum + nums[ind], nums, ans);

        // Recursively exclude the current element from the sum
        func(ind + 1, sum, nums, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SubsetSumGenerator obj = new SubsetSumGenerator();
        List<Integer> result = obj.subsetSums(nums);

        System.out.println("Subset sums are: " + result);

        sc.close();
    }
}