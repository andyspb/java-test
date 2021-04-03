package com.test.algorithm;

public class SelectionSort {
  // Prints the array
  void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; ++i) {
      int least = i;
      for (int j = i + 1; j < arr.length; ++j) {
        if (arr[j] < arr[least]) {
          least = j;
        }
      }
      int tmp = arr[i];
      arr[i] = arr[least];
      arr[least] = tmp;
    }
  }
  // Driver code to test above
  public static void main(String args[]) {
    SelectionSort ob = new SelectionSort();
    int arr[] = {64, 25, 12, 22, 11};
    System.out.println("Unsorted array");
    ob.printArray(arr);
    ob.selectionSort(arr);
    System.out.println("Sorted array");
    ob.printArray(arr);
  }
}
