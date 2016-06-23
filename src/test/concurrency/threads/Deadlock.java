package test.concurrency.threads;

public class Deadlock {
  final Object lock1 = new Object();
  final Object lock2 = new Object();

  public static void main(String[] args) {

    Deadlock d = new Deadlock();

    Thread t1 = new Thread(new Runnable() {
      public void run() {
        d.method1();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      public void run() {
        d.method2();
      }
    });

    t1.start();
    t2.start();

  }

  void method1() {
    synchronized (lock1) {
      synchronized (lock2) {
        System.out.println("from method1");
        // doSomething()
      }
    }
  }

  void method2() {
    synchronized (lock2) {
      synchronized (lock1) {
        System.out.println("from method2");
        // doSomething()
      }
    }
  }

}

