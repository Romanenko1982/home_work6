package store;

import interface_movable.Movable;
import java.util.ArrayList;

public class Store<T extends Movable> {

  private double amountOfMoney = 40000;
  private ArrayList<T> items;

  public Store(ArrayList<T> items) {
    this.items = items;
  }

  public void printProducts() {
    for (int i = 0; i < items.size(); i++) {
      System.out.println(i + 1 + items.get(i).toString());
    }
  }

  public T purchaseAtTheStore(int numberItem, double money) {
    double delta = items.get(numberItem - 1).getPrice() - money;
    while (money < items.get(numberItem - 1).getPrice()) {
      try {
        System.out.println("Вам не хватает денежных средств для преобретения товара " +
            items.get(numberItem - 1) + " т.к. его стоимость больше ваших денежных средств на "
            + delta);
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    amountOfMoney += items.get(numberItem - 1).getPrice();
    items.remove(numberItem - 1);
    return null;
  }

  public synchronized void sellToTheStore(double sellMoney, T item) {
    while (amountOfMoney < sellMoney) {
      try {
        System.out.println("Не хватает денежных средств в кассе");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (sellMoney > item.getPrice()) {
      System.out.println("Цена завышена");
    } else {
      amountOfMoney -= sellMoney;
      System.out.println("Ваш товар преобрел магазин за " + sellMoney + " рублей");
      items.add(item);
    }
    notify();
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



