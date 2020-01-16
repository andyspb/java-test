package com.hacker._30days;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DataTypes {
  public static void main(String[] args) {
    int i = 4;
    double d = 4.0;
    String s = "HackerRank ";

    int ii;
    double dd;
    String ss;

    Scanner scan = new Scanner(System.in);
    ii = scan.nextInt();
    dd = scan.nextDouble();
    ss = scan.next();

    System.out.println(i + ii);
    DecimalFormat df = new DecimalFormat("0.0");

    System.out.println(df.format(d + dd));
    System.out.println(s + ss);

    scan.close();
  }
}
