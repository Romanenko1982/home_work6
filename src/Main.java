import cars.abstractClass.Car;
import cars.modelsClass.Passenger;
import cars.modelsEnum.Brand;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import store.Consumer;
import store.Counter;
import store.Producer;
import store.Store;

public class Main {

  public static void main(String[] args) {

    Passenger passengerMercedes = new Passenger(Brand.MERCEDES, "Black",
        new GregorianCalendar(1980, Calendar.MARCH, 12), 130, 1000,
        10);

    ArrayList<Car> cars = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      cars.add(passengerMercedes);
    }

    Store<Car> store = new Store<>(cars);

    Consumer consumer = new Consumer(store);
    Producer producer = new Producer(store);

    Thread consumerThread = new Thread(consumer);
    Thread producerThread = new Thread(producer);

    System.out.println(consumerThread.getState());
    System.out.println(producerThread.getState());

    consumerThread.setDaemon(true);
    producerThread.setDaemon(true);

    consumerThread.start();
    producerThread.start();

    System.out.println(consumerThread.getState());
    System.out.println(producerThread.getState());

    System.out.println(consumerThread.isAlive());
    System.out.println(producerThread.isAlive());
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      consumerThread.join();
      System.out.println(consumerThread.getState());
      System.out.println(consumerThread.isAlive());
      System.out.println(Counter.getCounter());
      producerThread.join();
      System.out.println(producerThread.getState());
      System.out.println(producerThread.isAlive());
      System.out.println(Counter.getCounter());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Главный поток завершен.");
  }
}

