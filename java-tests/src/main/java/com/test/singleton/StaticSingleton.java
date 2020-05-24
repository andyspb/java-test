package com.test.singleton;

public class StaticSingleton {
  public static final StaticSingleton INSTANCE = new StaticSingleton();

  private StaticSingleton() {}

  public static StaticSingleton getInstance() {
    return INSTANCE;
  }
}
