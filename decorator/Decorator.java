public abstract class Decorator implements Person {
  private Person person; 
  public Decorator(Person person) {
    this.person = person; 
  }
  public String report() {
    return this.person.report();  
  }
}