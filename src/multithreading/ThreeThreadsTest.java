package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread implements Runnable {
  private static final Logger log = Logger.getLogger(MyThread.class.getName());

  private String name;
  private MyThread thread;

  public MyThread(String name, MyThread t) {
    this.name = name;
    this.thread = t;
  }

  @Override
  public void run() {
    if (thread != null) {
      thread.join();
    }
    log.log(Level.INFO, "From thread: " + name);
  }

}

public class ThreeThreadsTest {

  private static final Logger log = Logger.getLogger(ThreeThreadsTest.class.getName());

  public static void main(String[] args) {

    log.log(Level.INFO, ">>>");

    MyThread t1 = new MyThread("t1", null);
    MyThread t2 = new MyThread("t2", t1);
    MyThread t3 = new MyThread("t3", t2);

  }

}
