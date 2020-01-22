import java.util.*;

public class Yard extends Observable {
  public void acquire(String something) {
    this.setChanged();
    this.notifyObservers(something);
    this.clearChanged();
  }
}