package store;

import interface_movable.Movable;
import java.util.ArrayList;

public class Store<T extends Movable> {

  volatile private double amountOfMoney = 1000;
  volatile private ArrayList<T> items;


  public Store(ArrayList<T> items) {
    this.items = items;
  }

  public void printProducts() {
    for (int i = 0; i < items.size(); i++) {
      System.out.println(i + 1 + items.get(i).toString());
    }
  }

  public synchronized void purchaseAtTheStore(int numberItem) {
    T item = items.get(numberItem - 1);
    while (items.size() < 4) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(
        "Вы преобрели товар " + item + " за " + item.getPrice() + " рублей");
    amountOfMoney += item.getPrice();
    items.remove(numberItem - 1);
    notify();
  }

  public synchronized void sellToTheStore(T item) {
    while (amountOfMoney < item.getPrice()) {
      try {
        System.out.println("Не хватает денежных средств в кассе");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    amountOfMoney -= item.getPrice();
    System.out.println("Ваш товар преобрел магазин за " + item.getPrice() + " рублей");
    items.add(item);
    notify();
    System.out.println(amountOfMoney);
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



