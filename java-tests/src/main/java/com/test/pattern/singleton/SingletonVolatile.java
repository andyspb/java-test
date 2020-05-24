package com.test.pattern.singleton;

public class SingletonVolatile {
  private static volatile SingletonVolatile instance;

  private SingletonVolatile() {}

  public static SingletonVolatile getInstance() {
    if (null == instance) {
      synchronized (SingletonVolatile.class) {
        if (null == instance) {
          instance = new SingletonVolatile();
        }
      }
    }
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }
}
