package com.lux;

public class Test {

  public static void main(String[] args) {
    //
    String s1 = "abc";
    String s2 = "abc";
    String s3 = new String("abc");

    System.out.println(s1==s2);
    System.out.println(s1.equals(s2));

    System.out.println(s1==s3);
    System.out.println(s1.equals(s3));

    //
    final StringBuffer sb = new StringBuffer();
    sb.append("A");

    System.out.println(sb.toString());
  }
}
