public class BasketballPlayer extends Decorator {
  public BasketballPlayer(Person person) {
    super(person); 
  }
  public String report() {
    return super.report() + playBasketball();  
  }
  private String playBasketball() {
    return " who plays basketball ";  
  }
}