package search;

/**
 * Write a description of class Binary here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Binary {

  /**
   * Returns the index of the target value, or -1 if not found
   */
  public static int search(int[] arr, int target) {
    int l = 0;
    int r = arr.length - 1;
    int m;
    while (l <= r) {
      // Get middle value in between left and right bounds
      m = (int) ((l + r) / 2);
      if (arr[m] < target) {
        // Set bounds of the array to only the right half
        l = m + 1;
      } else if (arr[m] > target) {
        // Set bounds of the array to only the left half
        r = m - 1;
      } else {
        // Value found
        return m;
      }
    }
    // Value not found
    return -1;
  }

  public static int[] sort(int[] arr) {
    int[] sorted = arr;
    int n = sorted.length;
    int j;
    int temp;
    int k;
    for (int i = 0; i < n; i++) {
      j = i - 1;
      while (j >= 0 && sorted[i] < sorted[j]) {
        j--;
      }
      temp = sorted[i];
      k = i;
      while (k > j + 1) {
        sorted[k] = sorted[k - 1];
        k--;
      }
      sorted[k] = temp;
    }

    return sorted;

  }

  public static void main(String[] args) {
    int[] arr = { 53, 85, 93, 25, 39, 27, 42, 5, 24, 45, 33, 51, 5, 80, 4, 7, 91,
        31, 66, 71, 32, 19, 79, 58, 61, 82, 89, 63, 7, 4, 50, 10, 48, 24, 75, 19, 22,
        73, 54, 51, 25, 33, 20, 52, 79, 97, 70, 54, 63, 49 };

    // Remember that a binary search requires a sorted array!
    // You can use one of your sorting methods here.

    arr = sort(arr);

    ////////////////////////////////////////////////////////////
    // Do not change anything below this line!!
    ////////////////////////////////////////////////////////////
    boolean isSorted = true;
    for (int i = 0; i < arr.length - 1 && isSorted; i++) {
      if (arr[i] > arr[i + 1]) {
        isSorted = false;
      }
    }
    printResult("Is sorted?", isSorted);
    printResult(82, search(arr, 82) == 44); // Find index in unsorted or sorted array
    printResult(49, search(arr, 49) == 24);
    printResult(-4, search(arr, -4) == -1);
  }

  public static void printResult(int target, boolean result) {
    System.out.println("Search for " + target + ": " + ((result) ? "CORRECT" : "INCORRECT"));
  }

  public static void printResult(String target, boolean result) {
    System.out.println(target + ": " + ((result) ? "CORRECT" : "INCORRECT"));
  }

}
