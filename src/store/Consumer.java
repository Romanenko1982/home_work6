package store;

import cars.abstractClass.Car;

public class Consumer implements Runnable {
  Store<Car> store;
//  volatile static double money = 1100;

  public Consumer(Store<Car> store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 1; i < 5; i++) {
      store.purchaseAtTheStore(1);



    }
  }
}
