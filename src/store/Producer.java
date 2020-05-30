package store;

import cars.modelsClass.Bus;
import cars.modelsClass.Passenger;
import cars.modelsClass.Truck;
import cars.modelsEnum.Brand;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Producer implements Runnable {

  Store store;


  public Producer(Store store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 1; i < 5; i++) {
      store.sellToTheStore(999, new Passenger(Brand.MERCEDES, "Black",
          new GregorianCalendar(1980, Calendar.MARCH, 12), 130, 1000,
          10));
    }
  }
}
