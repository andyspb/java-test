package com.leet.array;

// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
// You may assume nums1 and nums2 cannot be both empty.

import java.util.Arrays;

public class MedianTwoSortedArrays2 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double med = 0;
    int[] m = new int[nums1.length + nums2.length];
    // merge array;
    int i = 0, j = 0;
    int k = 0;
    while (i < nums1.length && j < nums2.length) {
      m[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
    }
    while (i < nums1.length) m[k++] = nums1[i++];

    while (j < nums2.length) m[k++] = nums2[j++];

    System.out.println(Arrays.toString(m));
    return med;
  }

  public static void main(String[] args) {
    //
    int[] nums1 = new int[] {1, 2};
    int[] nums2 = new int[] {3, 4};
    MedianTwoSortedArrays2 mt = new MedianTwoSortedArrays2();
    double med = mt.findMedianSortedArrays(nums1, nums2);
    System.out.println(med);
  }
}
