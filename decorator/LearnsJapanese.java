public class LearnsJapanese extends Decorator {
  public LearnsJapanese(Person person) {
    super(person); 
  }
  public String report() {
    return super.report() + speaksJapanese();  
  }
  private String speaksJapanese() {
    return " who learns Japanese ";  
  }
}