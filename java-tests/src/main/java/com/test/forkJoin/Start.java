package com.test.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class Start {
  private static Logger LOGGER = Logger.getLogger(Start.class.getName());

  public static void main(String[] args) {
    LOGGER.info("Start main()");

    final int componentValue = 12;
    Long beginT = System.nanoTime();
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    Stream test = new Stream(componentValue, 0, componentValue);
    forkJoinPool.invoke(test);
    Long endT = System.nanoTime();
    Long timebetweenStartEnd = endT - beginT;
    LOGGER.info("=====time========" + timebetweenStartEnd);
  }
}
