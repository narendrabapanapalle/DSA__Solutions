import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CombinationSumSolver {

    // Recursive function as shown in the photo
    public void func(int ind, int[] arr, List<Integer> list, int sum, List<List<Integer>> ans) {

        // Base case: if sum becomes 0
        if (sum == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Base case: if sum becomes negative OR index reaches end
        if (sum < 0 || ind == arr.length) {
            return;
        }

        // ---------------- TAKE ----------------
        list.add(arr[ind]);
        func(ind, arr, list, sum - arr[ind], ans);

        // Backtrack (remove last element)
        list.remove(list.size() - 1);

        // ---------------- NOT TAKE ----------------
        func(ind + 1, arr, list, sum, ans);
    }

    // Main combinationSum function
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        func(0, candidates, list, target, ans);

        return ans;
    }

    // Driver code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();
        int[] candidates = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        // Read target
        int target = sc.nextInt();

        CombinationSumSolver obj = new CombinationSumSolver();
        List<List<Integer>> result = obj.combinationSum(candidates, target);

        System.out.println(result);

        sc.close();
    }
}