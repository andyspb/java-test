package com.test.language;

public interface OldInterface {
  public void existingMethod();

  public default void newDefaultMethod() {
    System.out.println("New default method is added in interface");
  }
}
