package cars.modelsEnum;

public enum Density {
  SAND(1.6), STONE(1.3), SAWDUST(0.4), KERAMZIT(0.9);

  private double density;

  Density(double density) {
    this.density = density;
  }

  public double getDensity() {
    return density;
  }

  public void setDensity(double density) {
    this.density = density;
  }
}
