package com.hacker.arrays;

public class NewYearChaos {

  static void minimumBribes(int[] q) {
    int bribe = 0;
    int l = q.length;
    for (int i = l -1; i >=0; --i) {
      if (q[i] - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = Math.max(0, q[i] - 2); j < i; ++j)
        if (q[j] > q[i]) ++bribe;
    }
    System.out.println(bribe);
  }

  public static void main(String[] args) {
    int arr[] = new int[] {2, 1, 5, 3, 4};
    minimumBribes(arr);
    int brr[] = new int[] {3};
    minimumBribes(brr);
  }
}
