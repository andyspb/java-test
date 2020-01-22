package com.test.test.lambda;

public class WorkerInterfaceTest {
  public static void execute(WorkerInterface worker) {
    worker.doSomeWork();
  }

  public static void main(String[] args) {

    execute(
        new WorkerInterface() {
          @Override
          public void doSomeWork() {
            System.out.println("Worker via anonymous class");
          }
        });

    execute(() -> System.out.println("Worker via Lambda"));
  }
}
