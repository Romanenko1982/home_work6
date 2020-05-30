package store;

public class Consumer implements Runnable {
  Store store;

  public Consumer(Store store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 1; i < 5 ; i++) {
      store.purchaseAtTheStore(1, 40000);
    }
  }
}
