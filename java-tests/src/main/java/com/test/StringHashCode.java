package com.test;

public class StringHashCode {
  public static int betterHash(String s) {
    int h = 0;
    int len = s.length();

    for (int i = 0; i < len; i++) {
      h = 257*h + s.charAt(i);
    }
    return h;
  }
  public void testHash() {
    System.out.println("A:" + (int)'A');
    System.out.println("B:" + (int)'B');
    System.out.println("a:" + (int)'a');

    System.out.println("Aa".hashCode() + "," + "BB".hashCode());
    System.out.println("Ba".hashCode() + "," + "CB".hashCode());
    System.out.println("Ca".hashCode() + "," + "DB".hashCode());
    System.out.println("Da".hashCode() + "," + "EB".hashCode());

    System.out.println("Siblings".hashCode() + "," + "Teheran".hashCode());

  }

  public static void main(String[] args) {
    StringHashCode st = new StringHashCode();
    st.testHash();

  }
}
