package com.test.algorithm;

public class BinarySearch {
  // Returns index of x if it is present in arr[l..r], else
  // return -1
  int binarySearch(int arr[], int start, int end, int x) {
    if (end >= start) {
      int mid = start + (end - start) / 2;

      // If the element is present at the middle itself
      if (arr[mid] == x) return mid;

      // If element is smaller than mid, then it can only
      // be present in left subarray
      if (arr[mid] > x) return binarySearch(arr, start, mid - 1, x);

      // Else the element can only be present in right
      // subarray
      return binarySearch(arr, mid + 1, end, x);
    }

    // We reach here when element is not present in array
    return -1;
  }

  // Driver method to test above
  public static void main(String args[]) {
    System.out.println("BinarySearch.main() >>>");
    BinarySearch bs = new BinarySearch();
    int arr[] = {2, 3, 4, 10, 40};
    int n = arr.length;
    int x = 10;
    int result = bs.binarySearch(arr, 0, n - 1, x);
    if (result == -1) System.out.println("Element not present");
    else System.out.println("Element found at index " + result);
  }
}
