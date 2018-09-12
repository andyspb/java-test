package concurent;

public class DeadlockTest {
  String str1 = "A";
  String str2 = "B";

  Thread t1 = new Thread("My Thread 1") {
    public void run() {
      System.out.println("Start thread: " + this.getName());
      while (true) {
        synchronized (str1) {
          synchronized (str2) {
            System.out.println(str1 + str2);
          }
        }
      }
    }

  };
  Thread t2 = new Thread("My Thread 2") {
    public void run() {
      System.out.println("Start thread: " + this.getName());
      while (true) {
        synchronized (str2) {
          synchronized (str1) {
            System.out.println(str2 + str1);
          }
        }
      }
    }
  };

  public static void main(String a[]) {
    DeadlockTest mdl = new DeadlockTest();
    mdl.t1.start();
    mdl.t2.start();
  }

}
