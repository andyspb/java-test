package com.test.java8;

import javassist.ClassPool;

public class Permgen {
  static ClassPool classPool = ClassPool.getDefault();

  public static void main(String args[]) throws Exception
  {
    for (int i = 0; i < 1000000000; i++) {
      Class c = classPool.makeClass("com.test.java8.Permgen." + i).toClass();
          System.out.println(c.getName());
    }
  }
}
