package com.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class Start {
  private static Logger LOGGER = Logger.getLogger(Start.class.getName());

  public static void main(String[] args) {
    LOGGER.info("Start main()");

    final int componentValue = 12;
    Long beginT = System.nanoTime();
    ForkJoinPool fjp = new ForkJoinPool();
    Stream test = new Stream(componentValue, 0, componentValue);
    fjp.invoke(test);
    Long endT = System.nanoTime();
    Long timebetweenStartEnd = endT - beginT;
    System.out.println("=====time========" + timebetweenStartEnd);

  }
}
