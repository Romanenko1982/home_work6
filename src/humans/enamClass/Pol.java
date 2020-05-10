package humans.enamClass;

public enum Pol {
  MAN("Мужской"), WOMAN("Женский");

  private String pol;

  Pol(String pol) {
    this.pol = pol;
  }

  public String getPol() {
    return pol;
  }

  public void setPol(String pol) {
    this.pol = pol;
  }
}
