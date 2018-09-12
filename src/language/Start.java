package language;

import java.util.concurrent.ForkJoinPool;

public class Start {
  public static void main(String... args) {
    final int componentValue = 2000;
    Long beginT = System.nanoTime();
    ForkJoinPool fjp = new ForkJoinPool();
    Stream test = new Stream(componentValue, 0, componentValue);
    Long countSum = fjp.invoke(test);
    Long endT = System.nanoTime();
    Long timebetweenStartEnd = endT - beginT;
    System.out.println("time: " + timebetweenStartEnd);
    System.out.println("countSum: " + countSum);

  }
}
