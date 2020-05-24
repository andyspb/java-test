package com.test.algorithm;

import java.util.logging.Logger;

public class Swaper {
  private static final Logger log = Logger.getLogger(Swaper.class.getName());

  public static void main(String[] args) {

    int a = 5;
    int b = 6;

    log.info("Swap integers: a=" + a + " b=" + b);

    // a = a^b;
    // b = a^b;
    // a = a^b;

    a = a + b;
    b = a - b;
    a = a - b;

    log.info("Result: a=" + a + " b=" + b);
  }
}
