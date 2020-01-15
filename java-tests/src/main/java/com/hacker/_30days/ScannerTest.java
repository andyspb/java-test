package com.hacker._30days;

import java.util.Scanner;

public class ScannerTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    String[] sArr = new String[num];
    for (int i = 0; i < num; ++i) {
      String str = sc.next();
      sArr[i] = str;
      System.out.println("str: " + str);
    }
    sc.close();
  }
}
