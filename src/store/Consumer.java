package store;

import cars.abstractClass.Car;

public class Consumer implements Runnable {

  Store<Car> store;
  volatile double moneyConsumer = 1000;

  public Consumer() {
  }

  public Consumer(Store<Car> store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 1; i < 5; i++) {
      store.purchaseAtTheStore(1, moneyConsumer);
//      try {
//        Thread.sleep(50);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
  }
}
