public class DecoratorExample {
  public static void main(String[] args) {
    Person p1 = new LearnsJapanese(new Student()); 
    System.out.println( p1.report() ); 
    Person p2 = new BasketballPlayer(new Student()); 
    System.out.println( p2.report() ); 
    p1 = new BasketballPlayer(p1); 
    System.out.println( p1.report() ); 
    p2 = new LearnsJapanese( p2 ); 
    System.out.println( p2.report() ); 
  }
}