public class Example {
  public static void main(String[] args) {
    ListOfNumber lon = cons(2, cons(3, cons(4, Nil.EMPTY)));
    show(lon); 
    show(cons(1, lon)); 
    try { 
      System.out.println( Nil.EMPTY.first() );
    } catch (Exception e) {
      System.out.println( "Darn..." ); // e );  
    }
  }
  public static ListOfNumber cons(int number, ListOfNumber lon) {
     return new Element(number, lon); 
  }
  public static void show(ListOfNumber lon) {
     if (lon == Nil.EMPTY) System.out.println("."); 
     else {
       System.out.print( lon.first() + " " ); 
       show(lon.rest()); 
     }
  }
}