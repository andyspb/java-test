package com.test.test;

abstract class Base {
  void fun() {
    System.out.println("Base fun() called");
  }
}

class Derived extends Base {}

public class AbstractTest {
  public static void main(String args[]) {
    Base d = new Derived();
    d.fun();
  }
}
