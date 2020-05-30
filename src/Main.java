import cars.abstractClass.Car;
import cars.modelsClass.Bus;
import cars.modelsClass.Passenger;
import cars.modelsClass.Truck;
import cars.modelsEnum.Brand;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import store.Consumer;
import store.Producer;
import store.Store;

public class Main {

  public static void main(String[] args) {

    Passenger passengerMercedes = new Passenger(Brand.MERCEDES, "Black",
        new GregorianCalendar(1980, Calendar.MARCH, 12), 130, 1000,
        10);
    Passenger passengerVolvo = new Passenger(Brand.VOLVO, "White",
        new GregorianCalendar(1980, Calendar.MARCH, 12), 150, 1200,
        6);
    Bus busMercedes = new Bus(Brand.MERCEDES, "Red", new GregorianCalendar(1980, Calendar.MARCH,
        12), 100, 1000, 8);
    Bus busVolvo = new Bus(Brand.VOLVO, "Red", new GregorianCalendar(1980, Calendar.MARCH,
        07), 110, 2000, 25);
    Truck truckMercedes = new Truck(Brand.MERCEDES, "Red", new GregorianCalendar(1980,
        Calendar.MARCH, 12), 80, 20000, 20);
    Truck truckVolvo = new Truck(Brand.VOLVO, "Grey", new GregorianCalendar(1980,
        Calendar.MARCH, 12), 90, 15000, 17);

//    ArrayList<Car> cars = new ArrayList<>();
//    for (int i = 0; i < 6; i++) {
//      cars.add(passengerMercedes);
//    }

    ArrayList<Car> cars = new ArrayList<>();
    cars.add(passengerMercedes);
    cars.add(passengerVolvo);
    cars.add(busMercedes);
    cars.add(busVolvo);
    cars.add(truckMercedes);
    cars.add(truckVolvo);

    Store<Car> store = new Store<>(cars);
    store.printProducts();

    Producer producer = new Producer(store);
    Consumer consumer = new Consumer(store);

    new Thread(producer).start();
    new Thread(consumer).start();



  }
}
