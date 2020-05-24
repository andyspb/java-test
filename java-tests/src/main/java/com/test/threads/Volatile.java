package com.test.threads;

public class Volatile {

  static int j = 0;
  static volatile int i = 0;

  private int a;
  public int b;

  public static void test() {}

  public void test1() {}

  public static void main(String... strings) {

    Volatile v = new Volatile();
    Volatile.Inner inner = v.new Inner();

    Volatile.WriteThread t = new Volatile.WriteThread();

    t.a = 6;

    t.start();
    new Volatile.ReadThread().start();
    System.out.println(i);
  }

  public class Inner {

    public void test() {
      Volatile.test();

      Volatile.this.test1();
    }

    private int i;
    public int j;
  }

  static class WriteThread extends Thread {

    private static int a = 1;

    @Override
    public void run() {

      Volatile.test();

      while (i < 5) {
        System.out.println("increase j:" + (++j));
        System.out.println("increase i:" + (++i));
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class ReadThread extends Thread {
    @Override
    public void run() {
      int localJValue = j;
      int localValue = i;
      while (localValue < 5) {
        if (localValue != i) {
          System.out.println(localJValue = j);
          System.out.println(localValue = i);
        }
      }
    }
  }
}
