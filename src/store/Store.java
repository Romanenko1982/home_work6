package store;

import interface_movable.Movable;
import java.util.ArrayList;

public class Store<T extends Movable> {

  Consumer consumer = new Consumer();
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

  public void purchaseAtTheStore(int numberItem, double purchaseMoney) {
    synchronized (this) {
      T item = items.get(numberItem - 1);
      while (items.size() < 1 || purchaseMoney < item.getPrice() ||
          consumer.moneyConsumer <= item.getPrice()) {
        try {
          System.out.println(Thread.currentThread().isAlive());
          System.out.println(Thread.currentThread().getState());
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(
          "Вы преобрели товар " + item + " за " + item.getPrice() + " рублей");
      amountOfMoney += item.getPrice();
      consumer.moneyConsumer -= item.getPrice();
      items.remove(numberItem - 1);
      System.out.println("Остаток денежных средств на счету магазина равен " + amountOfMoney);
      System.out.println("Остаток денежных средств на Вашем счету равен " + consumer.moneyConsumer);
      System.out.println("===========================================================");
      System.out.println(Thread.currentThread().isAlive());
      System.out.println(Thread.currentThread().getState());
      Counter.iteration();
      notify();
    }
  }

  public synchronized void sellToTheStore(double sellMoney, T item) {
    double delta = sellMoney - item.getPrice();
    double k = 1.1; // комиссионный сбор
    if (sellMoney > item.getPrice()) {
      System.out.println("Цена завышена, стоит снизить цену не менее чем на " + delta);
      sellMoney -= delta * k;
    }
    while (amountOfMoney < sellMoney) {
      System.out.println("Не хватает в кассе магазина необходимой суммы.");
      try {
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().getState());
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    amountOfMoney -= sellMoney;
    items.add(item);
    consumer.moneyConsumer += sellMoney;
    System.out.println("Ваш товар преобрел магазин за " + sellMoney + " рублей.");
    System.out.println("Остаток денежных средств в кассе магазина равен " + amountOfMoney);
    System.out.println("Остаток денежных средств на Вашем счету равен " + consumer.moneyConsumer);
    System.out.println("-----------------------------------------------------------");
    System.out.println(Thread.currentThread().isAlive());
    System.out.println(Thread.currentThread().getState());
    Counter.iteration();
    notify();
  }
}



