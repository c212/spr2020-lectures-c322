public class StrategyExample {
  public static void main(String[] args) {
    Person a, b, c; 
    a = new Person(new EnglishBrain(), new Body()); 
    a.talk(); 
    a.brain = new FrenchBrain();
    a.talk(); 
    b = new Person(new GermanBrain(), new Body()); 
    b.talk(); 
    c = new Person(new FrenchBrain(), new Body()); 
    c.talk(); 
    c.brain = new EnglishBrain(); 
    c.talk();
  }
}