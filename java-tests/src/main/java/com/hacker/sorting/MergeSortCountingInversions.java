package com.hacker.sorting;

public class MergeSortCountingInversions {

  static long countInversions(int[] arr) {
    if (arr == null || arr.length <= 1) return 0;
    return new MergeSort().sort(arr);
  }

  public static void main(String[] args) {
    int[] arr1 = new int[] {1, 1, 1, 2, 2};
    int[] arr2 = new int[] {2, 1, 3, 1, 2};

    MergeSort ms = new MergeSort();
    long swaps1 = countInversions(arr1);
    long swaps2 = countInversions(arr2);
    System.out.println(swaps1);
    System.out.println(swaps2);
  }

  private static class MergeSort {

    private int[] arr;
    private int[] temp;
    private int len;
    private long swaps;

    public long sort(int[] values) {
      this.arr = values;
      len = values.length;
      this.temp = new int[len];
      mergeSort(0, len - 1);
      return swaps;
    }

    private void mergeSort(int low, int high) {
      if (low < high) {
        int piv = low + ((high - low) >> 1);
        mergeSort(low, piv);
        mergeSort(piv + 1, high);
        merge(low, piv, high);
      }
    }

    private void merge(int low, int mid, int high) {
      for (int i = low; i <= high; i++) {
        temp[i] = arr[i];
      }

      int i = low, k = low, j = mid + 1;
      while (i <= mid && j <= high) {
        if (temp[i] <= temp[j]) {
          arr[k] = temp[i];
          ++i;
        } else {
          swaps += mid + 1 - i;
          arr[k] = temp[j];
          ++j;
        }
        ++k;
      }
      while (i <= mid) {
        arr[k] = temp[i];
        ++k;
        ++i;
      }
    }
  }
}
