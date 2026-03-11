import java.util.Scanner;

class SubsequenceSumChecker {

// This method recursively checks for the subsequence with the given sum
public boolean solve(int i, int n, int[] arr, int k) {

// Base case: if the sum k is 0, a subsequence is found
if (k == 0) {
return true;
}

// Base case: if k is negative, no valid subsequence can be found
if (k < 0) {
return false;
}

// Base case: if all elements are processed, check if k is 0
if (i == n) {
return k == 0;
}

// Recursive call: include the current element in the subsequence
// or exclude the current element from the subsequence
boolean path1 = solve(i + 1, n, arr, k - arr[i]);
boolean path2 = solve(i + 1, n, arr, k);

return path1 || path2;
}

// This method initiates the recursive process
public boolean checkSubsequenceSum(int[] nums, int target) {
int n = nums.length; // Get the length of the input array
return solve(0, n, nums, target); // Start the recursive process
}

// Main method
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

// Read size of array
int n = sc.nextInt();
int[] nums = new int[n];

// Read array elements
for (int i = 0; i < n; i++) {
nums[i] = sc.nextInt();
}

// Read target
int target = sc.nextInt();

SubsequenceSumChecker obj = new SubsequenceSumChecker();
System.out.println(obj.checkSubsequenceSum(nums, target));

sc.close();
}
}