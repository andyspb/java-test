package com.test.singleton;

public class SingletonVolatile {

  private static volatile SingletonVolatile instance;

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
}
