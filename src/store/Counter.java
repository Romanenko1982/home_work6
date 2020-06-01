package store;

public class Counter {
  private static int counter;

  public static synchronized void iteration() {
    counter++;
  }

  public static synchronized int getCounter() {
    return counter;
  }
}
