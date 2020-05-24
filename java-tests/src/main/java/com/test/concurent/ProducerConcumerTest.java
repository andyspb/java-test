package com.test.concurent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Logger;

public class ProducerConcumerTest {

  private static final Logger log = Logger.getLogger(Buffer.class.getName());

  public static void main(String[] args) {
    RingBuffer c = new RingBuffer();
    Producer p1 = new Producer(c, 1);
    Consumer c1 = new Consumer(c, 1);
    p1.start();
    c1.start();
  }
}

class Item {
  int data;
  int size;
}

class RingBuffer {
  private int contents;
  private Deque<Item> deque;
  private boolean available = false;

  RingBuffer() {
    deque = new ArrayDeque<>();
    // deque = new ArrayDeque<Item>();
  }

  synchronized int Size() {
    return deque.size();
  }

  public synchronized int get() {
    while (available == false) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    available = false;
    notifyAll();
    return contents;
  }

  public synchronized void put(int value) {
    while (available == true) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    contents = value;
    available = true;
    notifyAll();
  }
}

class Consumer extends Thread {
  private RingBuffer cubbyhole;
  private int number;

  public Consumer(RingBuffer c, int number) {
    cubbyhole = c;
    this.number = number;
  }

  public void run() {
    int value = 0;
    for (int i = 0; i < 10; i++) {
      value = cubbyhole.get();
      System.out.println("\t\tConsumer #" + this.number + " got: " + value);
    }
  }
}

class Producer extends Thread {
  private RingBuffer cubbyhole;
  private int number;

  public Producer(RingBuffer c, int number) {
    cubbyhole = c;
    this.number = number;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      cubbyhole.put(i);
      System.out.println("Producer #" + this.number + " put: " + i);
      try {
        sleep((int) (Math.random() * 100));
      } catch (InterruptedException e) {
      }
    }
  }
}
