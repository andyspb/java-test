package com.lux;

class MyThread extends Thread {
  public int count;

  public void run() {
    while (count <= 2020) {
      count++;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    MyThread myThread = new MyThread();
    myThread.start();
    myThread.join();
    System.out.println(myThread.count);
  }
}
