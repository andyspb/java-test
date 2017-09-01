package algorithm;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort {
  private static final Logger log = Logger.getLogger(MergeSort.class.getName());

  private int[] numbers;
  private int[] helper;
  private int number;

  public static void main(String[] args) {
    log.log(Level.INFO, "From MergeSort");
    int[] arr = {23,12,11,0,7,3,2};
    printArray(arr);
    MergeSort s = new MergeSort();
    s.sort(arr);
    printArray(arr);
  }
  

  public void sort(int[] values) {
    this.numbers = values;
    number = values.length;
    this.helper = new int[number];
    mergeSort(0, number - 1);
  }

  private void mergeSort(int low, int high) {
    // check if low is smaller than high, if not then the array is sorted
    if (low < high) {
      int middle = low + (high - low) / 2;
      mergeSort(low, middle);
      mergeSort(middle + 1, high);
      merge(low, middle, high);
    }
  }

  private void merge(int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      helper[i] = numbers[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers[k] = helper[i];
        ++i;
      } else {
        numbers[k] = helper[j];
        ++j;
      }
      ++k;
    }
    while (i <= middle) {
      numbers[k] = helper[i];
      ++k;
      ++i;
    }
  }

  
  /* A utility function to print array of size n */
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }
}
