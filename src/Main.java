import cars.abstractClass.Car;
import cars.modelsClass.Bus;
import cars.modelsClass.Passenger;
import cars.modelsClass.Truck;
import cars.modelsEnum.Brand;
import humans.enamClass.Sport;
import humans.personClass.Man;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        12), 100,
        1000, 8);
    Bus busVolvo = new Bus(Brand.VOLVO, "Red", new GregorianCalendar(1980, Calendar.MARCH,
        07), 110,
        2000, 25);
    Truck truckMercedes = new Truck(Brand.MERCEDES, "Red", new GregorianCalendar(1980,
        Calendar.MARCH, 12),
        80, 20000, 20);
    Truck truckVolvo = new Truck(Brand.VOLVO, "Grey", new GregorianCalendar(1980,
        Calendar.MARCH, 12), 90,
        15000, 17);
    Man man = new Man("Golubkov", "Lenia", 40, Sport.RUN, "actor");

//    Bus.BusChair busChair = busMercedes.new BusChair();
//    busChair.downChairBack();
//    busChair.getMaterialBusChair();
//    busChair.getCountDoubleSeat();
//    busChair.getCountSingleSeat();

//    Passenger.Tank tank = passengerVolvo.new Tank();
//    System.out.println(tank.isEnoughTankForADistance(91, 9));
//    passengerVolvo.move(91, 9);

//    Truck.SteeringWheel steeringWheel = truckVolvo.new SteeringWheel();
//    steeringWheel.left();
//    steeringWheel.right();
//    DumpTruck dumpTruck = truckMercedes.new DumpTruck();
//    dumpTruck.upBody(Density.SAND);
//    dumpTruck.downBody();

//    passengerMercedes.move(60, 5.99);

    ArrayList<Car> cars = new ArrayList<>();
    cars.add(passengerMercedes);
    cars.add(passengerVolvo);
    cars.add(passengerMercedes);
    cars.add(busVolvo);
    cars.add(truckMercedes);
    cars.add(truckVolvo);

    Store<Car> store = new Store<Car>(cars);
    store.printProducts();
    store.purchase(6, 15000);
    store.printProducts();
    System.out.println(store.getAmountOfMoney());
    store.sell(15000, truckVolvo);
    store.printProducts();
  }
}
