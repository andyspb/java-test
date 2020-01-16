package com.hacker._30days;

import java.util.Scanner;

public class LetsReview {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    String[] sArr = new String[num];
    for (int i = 0; i < num; ++i) {
      sArr[i] = sc.next();
    }
    sc.close();
    for (int j = 0; j < num; ++j) {
      int l = sArr[j].length();
      for (int i = 0; i < l; i += 2) {
        System.out.print(sArr[j].charAt(i));
      }
      System.out.print(' ');
      for (int i = 1; i < l; i += 2) {
        System.out.print(sArr[j].charAt(i));
      }
      System.out.println();
    }
  }
}
