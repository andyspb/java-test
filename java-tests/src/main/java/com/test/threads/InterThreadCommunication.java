package com.test.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterThreadCommunication {
  private static final Logger log = Logger.getLogger(InterThreadCommunication.class.getName());

  public static void main(String args[]) {

    log.log(Level.INFO, ">>>");

    final Queue<Integer> sharedQ = new LinkedList<Integer>();

    Thread producer = new Producer(sharedQ);
    Thread consumer = new Consumer(sharedQ);

    producer.start();
    consumer.start();

    log.log(Level.INFO, "<<<");
  }
}

class Producer extends Thread {

  private static final Logger log = Logger.getLogger(Producer.class.getName());
  private final Queue<Integer> sharedQ;

  public Producer(Queue<Integer> sharedQ) {
    super("Producer");
    this.sharedQ = sharedQ;
  }

  @Override
  public void run() {

    for (int i = 0; i < 4; i++) {

      synchronized (sharedQ) {
        // waiting condition - wait until Queue is not empty
        while (sharedQ.size() >= 1) {
          try {
            log.log(Level.INFO, "Queue is full, waiting");
            sharedQ.wait();
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }
        log.log(Level.INFO, "producing : " + i);
        sharedQ.add(i);
        sharedQ.notify();
      }
    }
  }
}

class Consumer extends Thread {

  private static final Logger log = Logger.getLogger(Consumer.class.getName());
  private final Queue<Integer> sharedQ;

  public Consumer(Queue<Integer> sharedQ) {
    super("Consumer");
    this.sharedQ = sharedQ;
  }

  @Override
  public void run() {
    while (true) {

      synchronized (sharedQ) {
        // waiting condition - wait until Queue is not empty
        while (sharedQ.size() == 0) {
          try {
            log.log(Level.INFO, "Queue is empty, waiting");
            sharedQ.wait();
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }
        int number = sharedQ.poll();
        log.log(Level.INFO, "consuming : " + number);
        sharedQ.notify();

        // termination condition
        if (number == 3) {
          break;
        }
      }
    }
  }
}
