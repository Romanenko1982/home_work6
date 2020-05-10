package cars.modelsClass;

import cars.abstractClass.Car;
import cars.modelsEnum.Brand;
import cars.modelsEnum.TypeCar;
import java.util.Calendar;
import java.util.Objects;

public class Passenger extends Car {

  private double accelerator;

  public Passenger(Brand brand, String color, Calendar calendar, double speed,
      double price, double accelerator) {
    super(brand, TypeCar.PASSENGER, color, calendar, speed, price);
    this.accelerator = accelerator;
  }

  @Override
  public void move() {
    System.out.println("Не еде, а лечу");
  }

  @Override
  public void accelerate() {
    double v = 0;
    while (v < getSpeed()) {
      if (v >= 0 && v <= 10) {
        System.out.println("1 передача");
      } else if (v > 10 && v <= 70) {
        System.out.println(("2 передача"));
      } else {
        System.out.println("3 передача");
      }
      v += 10;
    }
  }

  @Override
  public void brake() {
    double v = getSpeed();
    while (v != 0) {
      if (v > 70) {
        System.out.println("3 передача");
      } else if (v > 10 && v <= 70) {
        System.out.println(("2 передача"));
      } else if (v > 0 && v <= 10) {
        System.out.println("1 передача");
        System.out.println("Остановка");
      }
      v -= 10;
    }
  }

  public void move(double volume, double averageFuel) {
    if (new Tank().isEnoughTankForADistance(volume, averageFuel)) {
      System.out.println("Едем без дозаправки");
    } else {
      System.out.println("Нужна дозаправка");
    }
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder(super.toString());
    str.append("accelerator - ").append(accelerator);
    return str.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Passenger passenger = (Passenger) o;
    return Double.compare(passenger.accelerator, accelerator) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), accelerator);
  }

  public double getAccelerator() {
    return accelerator;
  }

  public void setAccelerator(double accelerator) {
    this.accelerator = accelerator;
  }

  public class Tank {

    public boolean isEnoughTankForADistance(double volume, double averageFuel) {
      return (DISTANCE / 100) * averageFuel < volume;
    }
  }
}
