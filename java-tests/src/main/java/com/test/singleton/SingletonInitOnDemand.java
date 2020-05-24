package com.test.singleton;

public class SingletonInitOnDemand {
  private SingletonInitOnDemand() {}

  private static class SingletonHolder {
    private static final SingletonInitOnDemand INSTANCE = new SingletonInitOnDemand();
  }

  public static SingletonInitOnDemand getInstance() {
    return SingletonHolder.INSTANCE;
  }
}
