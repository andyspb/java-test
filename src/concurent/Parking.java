package concurent;

import java.util.concurrent.Semaphore;

public class Parking {
  private static final boolean[] PARKING_PLACES = new boolean[5];
  private static final Semaphore SEMAPHORE = new Semaphore(5, true);

  public static void main(String[] args) throws InterruptedException {
    for (int i = 1; i <= 7; i++) {
      new Thread(new Car(i)).start();
      Thread.sleep(400);
    }
  }

  public static class Car implements Runnable {
    private int carNumber;

    public Car(int carNumber) {
      this.carNumber = carNumber;
    }

    @Override
    public void run() {
      System.out.printf("Car %d arrived to park.\n", carNumber);
      try {
        SEMAPHORE.acquire();

        int parkingNumber = -1;

        synchronized (PARKING_PLACES) {
          for (int i = 0; i < 5; i++)
            if (!PARKING_PLACES[i]) {
              PARKING_PLACES[i] = true;
              parkingNumber = i;
              System.out.printf("Car %d parked to the place %d.\n", carNumber, i);
              break;
            }
        }

        Thread.sleep(5000);
        synchronized (PARKING_PLACES) {
          PARKING_PLACES[parkingNumber] = false;
        }

        SEMAPHORE.release();
        System.out.printf("Car %d leaved the park.\n", carNumber);
      } catch (InterruptedException e) {}
    }
  }
}
