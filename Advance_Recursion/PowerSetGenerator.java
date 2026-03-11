import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PowerSetGenerator {

// Helper function to generate all subsets
private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
// Base case: if the index reaches the length of the array,
// add the current subset to the answer list
if (index == n) {
ans.add(new ArrayList<>(current));
return;
}

// Include the current element in the subset and move to the next element
current.add(nums[index]);

// Recursive case: Exclude the current element and move to the next element
backtrack(index + 1, n, nums, current, ans);

// Backtrack: remove the last added element to explore other subsets
current.remove(current.size() - 1);
backtrack(index + 1, n, nums, current, ans);
}

// Main function to generate the power set of the given array
public List<List<Integer>> powerSet(int[] nums) {
List<List<Integer>> ans = new ArrayList<>(); // List to store all subsets
List<Integer> current = new ArrayList<>(); // Temporary list to store the current subset
backtrack(0, nums.length, nums, current, ans); // Start the recursive process
return ans; // Return the list of all subsets
}

// Main method to test the code
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

// Read size of array
int n = sc.nextInt();
int[] nums = new int[n];

// Read array elements
for (int i = 0; i < n; i++) {
nums[i] = sc.nextInt();
}

PowerSetGenerator obj = new PowerSetGenerator();
List<List<Integer>> result = obj.powerSet(nums);

// Print the result
for (List<Integer> subset : result) {
System.out.println(subset);
}

sc.close();
}
}