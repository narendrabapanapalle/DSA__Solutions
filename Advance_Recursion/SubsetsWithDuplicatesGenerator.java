import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class SubsetsWithDuplicatesGenerator {

    private void func(int ind, List<Integer> arr, int[] nums, List<List<Integer>> ans) {
        // If index reaches the end of nums
        if (ind == nums.length) {
            // Add the current subset (arr) to the result
            ans.add(new ArrayList<>(arr));
            return;
        }

        // Include the current element in the subset
        arr.add(nums[ind]);

        // Recur for the next index
        func(ind + 1, arr, nums, ans);

        // Backtrack: remove the current element
        arr.remove(arr.size() - 1);

        // Skip duplicates and recur for the next unique element
        for (int j = ind + 1; j < nums.length; j++) {
            if (nums[j] != nums[ind]) {
                func(j, arr, nums, ans);
                return;
            }
        }

        // Ensure the function finishes when no more unique elements are left
        func(nums.length, arr, nums, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        Arrays.sort(nums); // Sort to handle duplicates

        func(0, arr, nums, ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Read elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SubsetsWithDuplicatesGenerator obj = new SubsetsWithDuplicatesGenerator();

        List<List<Integer>> result = obj.subsetsWithDup(nums);

        // Print result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }

        sc.close();
    }
}