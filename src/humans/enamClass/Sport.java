package humans.enamClass;

public enum Sport {
  FOOTBALL("футбол"), BASKETBALL("баскетбол"), HOCKEY("хоккей"), RUN("бег");

  private String sport;

  Sport(String sport) {
    this.sport = sport;
  }

  public String getSport() {
    return sport;
  }

  public void setSport(String sport) {
    this.sport = sport;
  }


}
