package com.hacker.algorithms.dynamicrpogramming;

import java.util.ArrayList;
import java.util.Arrays;

// python
// def compute_score(group_1, group_2):
//    score = 0
//    for i in group_1:
//        for j in group_2:
//            score += abs(i - j)
//    return score
//
// def fairCut(k, arr):
//    arr.sort()
//
//    if 2 * k > n:
//        k = n - k
//
//    start = (len(arr) - 2 * k) // 2
//    stop = start + 2 * k
//    group_1, group_2 = [], []
//
//    for i in range(len(arr)):
//    if stop >= i >= start and (i - start) % 2 == 1:
//    group_1.append(arr[i])
//    else:
//    group_2.append(arr[i])
//
//    return compute_score(group_1, group_2)

public class FairCut {
  public static long compute_score(ArrayList<Long> li, ArrayList<Long> lu) {
    long score = 0;
    for (int i = 0; i < li.size(); i++) {
      for (int j = 0; j < lu.size(); j++) {
        score += Math.abs(li.get(i) - lu.get(j));
      }
    }
    return score;
  }

  static int fairCut(int k, int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    if (2 * k > n) k = n - k;
    int start = (arr.length - 2 * k) / 2;
    int stop = start + 2 * k;
    ArrayList<Long> li = new ArrayList<>();
    ArrayList<Long> lu = new ArrayList<>();
    for (int i = 0; i < arr.length; ++i) {
      if ((stop >= i && i >= start) && ((i - start) % 2 == 1)) {
        li.add((long) arr[i]);
      } else {
        lu.add((long) arr[i]);
      }
    }
    int score = (int) compute_score(li, lu);
    return score;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {4, 3, 1, 2};
    int k = 2;
    int fair = fairCut(k, arr);
    System.out.println(fair);
  }
}
