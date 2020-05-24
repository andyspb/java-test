package com.test.test.memory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoryTest {

  private static final Logger log = Logger.getLogger(MemoryTest.class.getName());

  private static volatile int counter = 0;

  public MemoryTest() {}

  public void updateCounter() {}

  public static void main(String[] args) {
    log.log(Level.INFO, ">>>");
  }
}
