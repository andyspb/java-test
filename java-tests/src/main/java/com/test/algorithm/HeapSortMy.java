package com.test.algorithm;

import java.util.Arrays;

public class HeapSortMy {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] arr = {12, 2, 15, 56, 23, 78, 45, 34, 16, 91, 53, 27};
    System.out.print(Arrays.toString(arr) + '\n');

    heapsort(arr);

    System.out.println("-----------");

    System.out.print(Arrays.toString(arr) + '\n');
  }

  // sort num[1] to num[n]

  public static void heapsort(int[] arr) {
    int t = arr.length / 2 - 1;
    System.out.println("arr.length: " + arr.length + "arr.length / 2 - 1:" + t);
    for (int i = arr.length / 2 - 1; i >= 0; i--) { // convert the array to a heap

      System.out.print("heapsort before: " + '\t' + "i:" + i + '\t' + Arrays.toString(arr) + '\n');
      downHeap(arr, i, arr.length);
      System.out.print("heapsort afer: " + '\t' + "i:" + i + '\t' + Arrays.toString(arr) + '\n');
    }

    System.out.print("before last downheap" + Arrays.toString(arr) + '\n');

    for (int i = arr.length - 1; i > 0; i--) {
      System.out.println("arr[" + 0 + "]=" + arr[0] + "  <-->  " + "arr[" + i + "]=" + arr[i]);

      int temp = arr[i];
      arr[i] = arr[0];
      arr[0] = temp;
      downHeap(arr, 0, i);
    }
  } // end heapSort

  private static void downHeap(int[] arr, int i, int n) {

    System.out.println("downHeap(" + Arrays.toString(arr) + ", " + i + ", " + n);

    int child_index;
    int tmp_value;

    for (tmp_value = arr[i]; 2 * i + 1 < n; i = child_index) {
      child_index = 2 * i + 1;
      if (child_index != n - 1 && (arr[child_index] < arr[child_index + 1])) {
        child_index++;
      }
      if (tmp_value < arr[child_index]) {
        arr[i] = arr[child_index];
      } else {
        break;
      }
    }
    arr[i] = tmp_value;
  }
}
