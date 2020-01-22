public class Person {
  Brain brain;
  Body body;
  public Person(Brain brain, Body body) {
    this.brain = brain; 
    this.body = body;
  }
  public void talk() {
    System.out.println( this.brain.think() );  
  }
}