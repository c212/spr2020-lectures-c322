import java.util.*;

public class Pet {
  String name;
  public Pet(String name) {
    this.name = name;
  }
  public void update(Observable a, Object b) {
    System.out.println( this + "(" + this.name + ") sees a " + b + " thrown into the " + a );
  }
}