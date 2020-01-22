package com.test.singleton;

public class SingletonStaticBlockInit {

  private static final SingletonStaticBlockInit instance;

  static {
    try {
      instance = new SingletonStaticBlockInit();
    } catch (Exception e) {
      throw new RuntimeException("Darn, an error occurred!", e);
    }
  }

  public static SingletonStaticBlockInit getInstance() {
    return instance;
  }

  private SingletonStaticBlockInit() {
    // ...
  }
}
