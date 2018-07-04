package forkJoin;

import java.util.concurrent.ForkJoinPool;

public class Start {
  public static void main(String[] args) {
    System.out.println("Start main()");

    final int componentValue = 1000000;
    Long beginT = System.nanoTime();
    ForkJoinPool fjp = new ForkJoinPool();
    Stream test = new Stream(componentValue, 0, componentValue);
    fjp.invoke(test);
    Long endT = System.nanoTime();
    Long timebetweenStartEnd = endT - beginT;
    System.out.println("=====time========" + timebetweenStartEnd);

  }
}
