import java.util.Scanner;

class SubsequenceCounter {

// Helper function to count subsequences
// with the target sum
private int func(int ind, int sum, int[] nums) {

// Base case: if sum is 0, one valid
// subsequence is found
if (sum == 0) return 1;

// Base case: if sum is negative or
// index exceeds array size
if (sum < 0 || ind == nums.length) return 0;

// Recurse by including current number
// or excluding it from the sum
int ans1 = func(ind + 1, sum - nums[ind], nums);
int ans2 = func(ind + 1, sum, nums);

return ans1 + ans2;
}

// Function to start counting subsequences
public int countSubsequenceWithTargetSum(int[] nums, int target) {
return func(0, target, nums);
}

// Main function
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

// Read size of array
int n = sc.nextInt();
int[] nums = new int[n];

// Read elements
for (int i = 0; i < n; i++) {
nums[i] = sc.nextInt();
}

// Read target
int target = sc.nextInt();

SubsequenceCounter obj = new SubsequenceCounter();
System.out.println(obj.countSubsequenceWithTargetSum(nums, target));

sc.close();
}
}