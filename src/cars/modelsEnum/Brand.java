package cars.modelsEnum;

public enum Brand {
  VOLVO("Volvo", "Sweden"), MERCEDES("Mercedes Benz", "Germany");

  private String name;
  private String country;

  Brand(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
