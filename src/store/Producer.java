package store;

import cars.abstractClass.Car;
import cars.modelsClass.Passenger;
import cars.modelsEnum.Brand;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Producer implements Runnable {

  Store<Car> store;

  public Producer(Store<Car> store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 1; i < 5; i++) {
      store.sellToTheStore(900, new Passenger(Brand.MERCEDES, "Black",
          new GregorianCalendar(1980, Calendar.MARCH, 12), 130, 1000,
          10));
//      try {
//        Thread.sleep(50);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
  }
}
