package cars.modelsClass;

import cars.abstractClass.Car;
import cars.modelsEnum.Brand;
import cars.modelsEnum.Density;
import cars.modelsEnum.TypeCar;
import java.util.Calendar;
import java.util.Objects;

public class Truck extends Car {

  private double capacity;

  public Truck(Brand brand, String color, Calendar calendar, double speed,
      double price, double capacity) {
    super(brand, TypeCar.TRUCK, color, calendar, speed, price);
    this.capacity = capacity;
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
      v += 3;
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
      v -= 3;
    }
  }

  @Override
  public void move() {
    System.out.println("Truck move slowly");
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder(super.toString());
    str.append("capacity - ").append(capacity);
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
    Truck truck = (Truck) o;
    return Double.compare(truck.capacity, capacity) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), capacity);
  }

  public double getCapacity() {
    return capacity;
  }

  public void setCapacity(double capacity) {
    this.capacity = capacity;
  }

  public class SteeringWheel {

    public void right() {
      System.out.println("Проверили поворот вправо");
    }

    public void left() {
      System.out.println("Проверили поворот влево");
    }
  }

  public class DumpTruck {

    private int countHydraulicCylinder;
    private double weight;

    public void upBody(Density density) {
      calculateWeightCargo(density);
      System.out.println("Вверх подняли кузов, груз высыпался массой " + weight);
      if (weight <= 10) {
        countHydraulicCylinder = 1;
        System.out.println("Задействован 1 гидроцилиндр ");
      } else {
        countHydraulicCylinder = 2;
        System.out.println("Задействованы 2 гидроцилиндра ");
      }
    }

    public void downBody() {
      System.out.println("Вниз опущен кузов ");
    }

    public double calculateWeightCargo(Density density) {
      weight = capacity * density.getDensity();
      System.out.println("Масса перевезенного груза при полной загрузке составила " + weight);
      return weight;
    }
  }
}

