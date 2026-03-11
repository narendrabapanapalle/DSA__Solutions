import java.util.*;

public class SelectionSortUserInput {

  public int[] selectionSort(int[] nums) {
    // Loop through unsorted part of the array (0 to n-2)
    for (int i = 0; i < nums.length - 1; i++) {
      /*Assume current element 
      is the minimum*/
      int minIndex = i;

      // Find actual minimum in unsorted part (i+1 to n-1)
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }

      // Swap only if minIndex changed
      if (minIndex != i) {
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
      }
    }

    return nums;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of elements: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter array elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    SelectionSortUserInput solution = new SelectionSortUserInput();

    int[] sortedArr = solution.selectionSort(arr);

    System.out.print("Sorted array: ");
    for (int num : sortedArr) {
      System.out.print(num + " ");
    }
  }
}