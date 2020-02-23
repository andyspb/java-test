package com.test.inner;

public class Outer {
  private int i;
  private static int ii = 10;

  private static class StaticInner {
    private int a = 3;

    private void printOuterII() {
      System.out.println(Outer.ii);
    }
  }

  public static void main(String... args) {

    Outer.StaticInner si = new Outer.StaticInner();
    si.a = 0;
    System.out.println(si.a);
    si.printOuterII();
  }

}
