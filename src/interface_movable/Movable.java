package interface_movable;

public interface Movable {

  final int DISTANCE = 1000;

  void move();

  default void beforeMove() {
    System.out.println("Ready to move");
  }

  double getPrice();
}

