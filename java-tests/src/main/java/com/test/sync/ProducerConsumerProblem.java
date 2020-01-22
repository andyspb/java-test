package com.test.sync;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerProblem {

  public static void main(String args[]) {
    System.out.println("ProducerConsumerProblem main() >>>");
    // Creating shared object
    BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

    // Creating Producer and Consumer Thread
    Thread prod = new Thread(new Producer_Sync(sharedQueue));
    Thread cons = new Thread(new Consumer_Sync(sharedQueue));

    // Starting producer and Consumer thread
    prod.start();
    cons.start();
    System.out.println("ProducerConsumerProblem <<< ");
  }
}

// Producer Class in java
class Producer_Sync implements Runnable {

  private final BlockingQueue<Integer> sharedQueue;

  public Producer_Sync(BlockingQueue<Integer> sharedQueue) {
    this.sharedQueue = sharedQueue;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println("Produced: " + i);
        sharedQueue.put(i);
      } catch (InterruptedException ex) {
        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}

// Consumer Class in Java
class Consumer_Sync implements Runnable {

  private final BlockingQueue<Integer> sharedQueue;

  public Consumer_Sync(BlockingQueue<Integer> sharedQueue) {
    this.sharedQueue = sharedQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("Consumed: " + sharedQueue.take());
      } catch (InterruptedException ex) {
        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
