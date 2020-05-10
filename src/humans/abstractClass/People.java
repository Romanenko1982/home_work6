package humans.abstractClass;

import humans.enamClass.Pol;
import interface_movable.Movable;

public abstract class People implements Movable {

  private String surname;
  private String name;
  private int age;
  private Pol pol;

  public People(String surname, String name, int age, Pol pol) {
    this.surname = surname;
    this.name = name;
    this.age = age;
    this.pol = pol;
  }

  @Override
  public void move() {
    if (age < 2) {
      System.out.println("Пока еще только ползать");
    } else if (age >= 2 && age < 3) {
      System.out.println("Мелкими перебежками оказывается можно передвигаться");
    } else if (age >= 3 && age < 60) {
      System.out.println("Ну хожу и хожу ...");
    } else if (age >= 60 && age < 80) {
      System.out.println("Мелкими перебежками только и можно передвигаться");
    } else {
      System.out.println("Теперь уже только ползать");
    }
  }

  public abstract void run();

  public abstract void work();


}
