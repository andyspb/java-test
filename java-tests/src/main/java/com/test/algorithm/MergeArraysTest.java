package com.test.algorithm;

import com.test.util.Utils;

public class MergeArraysTest {

  public void mergeArrays(int[] in1, int[] in2, int[] out) throws Exception {
    int l1 = in1.length;
    int l2 = in2.length;
    int l3 = out.length;
    Utils.log("l1=" + l1 + " l2=" + l2 + " l3=" + l3);
    if ((l1 + l2) != l3) {
      Utils.log("incorrect length");
      throw new Exception("Error. Incorrect array length");
    }
    int i = 0, j = 0, k = 0;

    while (k != out.length) {
      Utils.log("i=" + i + " j=" + j + " k=" + k);
      if (i < l1 && in1[i] <= in2[j]) {
        out[k++] = in1[i++];
      } else if (j < l2) {
        out[k++] = in2[j++];
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Merging of two arrays:");

    int[] a1 = new int[] {21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
    int[] a2 = new int[] {10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};

    int[] a3 = new int[a1.length + a2.length];

    Utils.printArray(a1);
    Utils.printArray(a2);

    try {
      new MergeArraysTest().mergeArrays(a1, a2, a3);
    } catch (Exception e) {
    }

    Utils.printArray(a3);
  }
}
