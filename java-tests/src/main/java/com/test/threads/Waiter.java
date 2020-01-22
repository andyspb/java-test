package com.test.threads;

public class Waiter implements Runnable {
  private Message msg;

  public Waiter(Message m) {
    this.msg = m;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    synchronized (msg) {
      try {
        System.out.println(name + " ���� ����� ������ notify: " + System.currentTimeMillis());
        msg.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + " ��� ����� ������ notify: " + System.currentTimeMillis());
      System.out.println(name + " : " + msg.getMsg());
    }
  }
}
