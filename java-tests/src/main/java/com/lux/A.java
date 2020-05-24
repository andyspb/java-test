package com.lux;

class A extends Thread {
  public int count;

  public void run() {
    while (count <= 2020) {
      count++;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    A a = new A();
    a.start();
    a.join();
    System.out.println(a.count);
  }
}
