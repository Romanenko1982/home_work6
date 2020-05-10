package cars.abstractClass;

import cars.modelsEnum.Brand;
import cars.modelsEnum.TypeCar;
import interface_movable.Movable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public abstract class Car implements Movable {

  private Brand brand;
  private TypeCar typeCar;
  private String color;
  private Calendar calendar;
  private double speed;
  private double price;

  public Car(Brand brand, TypeCar typeCar, String color, Calendar calendar, double speed,
      double price) {
    this.brand = brand;
    this.typeCar = typeCar;
    this.color = color;
    this.calendar = calendar;
    this.speed = speed;
    this.price = price;
  }

  public boolean isMove() {
    return speed > 0;
  }

//  public abstract void move();

  public abstract void accelerate();

  public abstract void brake();

  private String convertToString() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    return simpleDateFormat.format(calendar.getTime());
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("Car brand - ").append(brand).append(", typeCar - ").append(typeCar)
        .append(", color - ").append(color).append(", date of made - ").append(convertToString())
        .append(", speed - ").append(speed).append(" км/ч, ").append(", price ").append(price)
        .append(" $");
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
    Car car = (Car) o;
    return Double.compare(car.speed, speed) == 0 &&
        Double.compare(car.price, price) == 0 &&
        brand == car.brand &&
        typeCar == car.typeCar &&
        color.equals(car.color) &&
        calendar.equals(car.calendar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, typeCar, color, calendar, speed, price);
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public TypeCar getTypeCar() {
    return typeCar;
  }

  public void setTypeCar(TypeCar typeCar) {
    this.typeCar = typeCar;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Date getCalendar() {
    return calendar.getTime();
  }

  public void setCalendar(Calendar calendar) {
    this.calendar = calendar;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
