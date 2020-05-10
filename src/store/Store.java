package store;

import cars.abstractClass.Car;
import java.util.ArrayList;

public class Store<T extends Car> {

  private double amountOfMoney = 1000;
  private ArrayList<T> items;

  public Store(ArrayList<T> items) {
    this.items = items;
  }

  public void printProducts() {
    for (int i = 0; i < items.size(); i++) {
      System.out.println(i + 1 + items.get(i).toString());
    }
  }

  public T purchase(int numberItem, double money) {
    if (money >= items.get(numberItem - 1).getPrice()) {
      amountOfMoney += items.get(numberItem - 1).getPrice();
      return items.remove(numberItem - 1);
    } else {
      throw new Error("Вам не хватает денежных средств");
    }
  }

  public void sell(double sellMoney, T item) {
    if (sellMoney > item.getPrice()) {
      throw new Error("Цена завышена");
    } else if (sellMoney > amountOfMoney) {
      throw new Error("Не хватает денежных средств в кассе");
    } else {
      amountOfMoney -= sellMoney;
      items.add(item);
    }
  }

  public double getAmountOfMoney() {
    return amountOfMoney;
  }

  public void setAmountOfMoney(double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public ArrayList<T> getItems() {
    return items;
  }

  public void setItems(ArrayList<T> items) {
    this.items = items;
  }
}



