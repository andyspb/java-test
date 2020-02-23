package com.test.threads;

import java.util.concurrent.CountDownLatch;

public class Race {
  private static final CountDownLatch START_COUNT_DOWN_LATCH = new CountDownLatch(8);
  private static final int trackLength = 500000;

  public static void main(String[] args) throws InterruptedException {
    for (int i = 1; i <= 5; i++) {
      new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
      Thread.sleep(1000);
    }

    while (START_COUNT_DOWN_LATCH.getCount() > 3) {
      Thread.sleep(100);
    }

    Thread.sleep(1000);
    System.out.println("On start!");
    START_COUNT_DOWN_LATCH.countDown();//Команда дана, уменьшаем счетчик на 1
    Thread.sleep(1000);
    System.out.println("Attention!");
    START_COUNT_DOWN_LATCH.countDown();//Команда дана, уменьшаем счетчик на 1
    Thread.sleep(1000);
    System.out.println("GO!");
    START_COUNT_DOWN_LATCH.countDown();//Команда дана, уменьшаем счетчик на 1
    //счетчик становится равным нулю, и все ожидающие потоки
    //одновременно разблокируются
  }

  public static class Car implements Runnable {
    private int carNumber;
    private int carSpeed;//считаем, что скорость автомобиля постоянная

    public Car(int carNumber, int carSpeed) {
      this.carNumber = carNumber;
      this.carSpeed = carSpeed;
    }

    @Override
    public void run() {
      try {
        System.out.printf("Car №%d got to start line.\n", carNumber);
        START_COUNT_DOWN_LATCH.countDown();
        START_COUNT_DOWN_LATCH.await();
        Thread.sleep(trackLength / carSpeed);//ждем пока проедет трассу
        System.out.printf("Car №%d finished!\n", carNumber);
      } catch (InterruptedException e) {
      }
    }
  }
}
