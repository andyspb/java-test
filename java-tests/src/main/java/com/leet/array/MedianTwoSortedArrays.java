package com.leet.array;

// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
// You may assume nums1 and nums2 cannot be both empty.

public class MedianTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length1 = nums1.length;
    int length2 = nums2.length;
    if ((length1 + length2) % 2 == 0) { // even
      return (findkthItemInSortedArrays(nums1, 0, nums2, 0, (length1 + length2) / 2)
              + findkthItemInSortedArrays(nums1, 0, nums2, 0, (length1 + length2) / 2 + 1))
          / 2.0;
    } else { // add
      return findkthItemInSortedArrays(nums1, 0, nums2, 0, (length1 + length2 + 1) / 2);
    }
  }

  private double findkthItemInSortedArrays(
      int[] nums1, int start1, int[] nums2, int start2, int k) {
    int n = nums1.length - start1;
    int m = nums2.length - start2;
    if (k == 0 || (n + m) < k) {
      return -1;
    }
    if (n <= 0) {
      return nums2[start2 + k - 1];
    }
    if (m <= 0) {
      return nums1[start1 + k - 1];
    }
    if (k == 1) {
      return Math.min(nums1[start1], nums2[start2]);
    }
    int A_value = (k / 2 <= n) ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
    int B_value = (k / 2 <= m) ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
    if (A_value >= B_value) {
      return findkthItemInSortedArrays(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    } else {
      return findkthItemInSortedArrays(nums1, start1 + k / 2, nums2, start2, k - k / 2);
    }
  }

  public static void main(String[] args) {
    //
    int[] nums1 = new int[] {1, 2};
    int[] nums2 = new int[] {3, 4};
    MedianTwoSortedArrays mt = new MedianTwoSortedArrays();
    double med = mt.findMedianSortedArrays(nums1, nums2);
    System.out.println(med);
  }
}
