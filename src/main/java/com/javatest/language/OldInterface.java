package com.javatest.language;

public interface OldInterface {
  public void existingMethod();

  default public void newDefaultMethod() {
    System.out.println("New default method is added in interface");
  }

}
