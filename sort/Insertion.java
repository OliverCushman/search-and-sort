package sort;

import java.util.Arrays;

/**
 * Write a description of class Insertion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Insertion
{
  
  /**
   * Returns the sorted array
   */
  public static int[] sort(int[] arr) {
    int n = arr.length;
    int j;
    int temp;
    int k;
    for (int i = 0; i < n; i++) {
      j = i - 1;
      // Compare every value to the left of i to the value at i
      // If the value is less than the value at i, stop
      while (j >= 0 && arr[i] < arr[j]) {
        j--;
      }
      temp = arr[i];
      k = i;
      // Move every value to the left of i forward to make room for the value at i
      while (k > j + 1) {
        arr[k] = arr[k - 1];
        k--;
      }
      // Insert the value that was at i into the available index at k
      arr[k] = temp;
    }

    return arr;

  }
  
  public static void main(String[] args) {
    int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
      31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    
    // Test the sort
    testSort(sort(arr));
  }
  
  public static void testSort(int[] arr) {
    for (int i=0; i<arr.length-1; i++) {
      if (arr[i] > arr[i+1]) {
        System.out.println("FAIL at index "+i);
        System.out.println(Arrays.toString(arr));
        return;
      }
    }
    System.out.println("SUCCESS!");
  }

}
