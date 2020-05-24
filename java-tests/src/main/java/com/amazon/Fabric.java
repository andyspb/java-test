package com.amazon;

public class Fabric {

  private static Fabric fabric = new Fabric();

  public static Fabric getInstance() {
    return fabric;
  }
}
