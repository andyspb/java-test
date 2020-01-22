package com.test.test;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

class A {
  protected A() {
    i = 2;
  }

  private int i;

  public int getI() {
    return i;
  }
}

class B extends A {}

public class PrivateTest {
  private static final Logger log = Logger.getLogger(PrivateTest.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, ">>>");
    B b = new B();
    Field f;
    try {
      f = A.class.getDeclaredField("i");
      f.setAccessible(true);
      int i = (int) f.get(b);
      System.out.println("i=" + i);
      System.out.println("from b i=" + b.getI());
    } catch (NoSuchFieldException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
