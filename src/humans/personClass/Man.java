package humans.personClass;

import humans.abstractClass.People;
import humans.enamClass.Pol;
import humans.enamClass.Sport;
import java.util.Objects;


public class Man extends People {

  private Sport sport;
  private String profession;

  public Man(String surname, String name, int age, Sport sport, String profession) {
    super(surname, name, age, Pol.MAN);
    this.sport = sport;
    this.profession = profession;
  }

  @Override
  public void move() {
    System.out.println("Как же эти девушки так ходят красиво?");
  }

  @Override
  public void run() {
    switch (sport) {
      case RUN:
        System.out.println("Самый быстрый");
        break;
      case HOCKEY:
        System.out.println("Лучше всех катается на коньках");
        break;
      case FOOTBALL:
        System.out.println("Да, нужно помочь сборной России");
        break;
      case BASKETBALL:
        System.out.println("Во выбрал спорт");
      default:
        System.out.println("аааа");
    }
  }

  @Override
  public void work() {
    System.out.println("Ох нелегкая эта работ, кулаком убивать бегемота");
  }

  @Override
  public String toString() {
    return super.toString() + "sport - " + sport + "profession - " + profession;
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
    Man man = (Man) o;
    return sport == man.sport &&
        profession.equals(man.profession);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sport, profession);
  }

  public Sport getSport() {
    return sport;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }
}
