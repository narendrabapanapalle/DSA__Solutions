import java.util.*;

public class TwoSumII167 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Read sorted array
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // Read target
        int target = sc.nextInt();

        int[] result = twoSum(numbers, target);

        // Print result (1-indexed)
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // Guaranteed one solution by problem statement
        return new int[]{-1, -1};
    }
}
