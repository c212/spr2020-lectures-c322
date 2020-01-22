public class Thursday {
  public static void main(String[] args) {
    Rock a = new Rock("Rocky"); // this is an Observer (actually not)
    Dog b = new Dog("Comet"); // this is an Observer also
    Dog c = new Dog("Evening"); // this is an Observer also
    Yard u = new Yard(); // maybe the yard is an Observable (source of events)
    Yard w = new Yard(); // another Observable (source of events)
    // tell a and b that u is to be watched
    System.out.println( u.countObservers() );
    u.addObserver( b ); // leave Rocky out of it
    System.out.println( u.countObservers() );
    u.addObserver( c );
    w.addObserver( c );
    System.out.println( u.countObservers() );
    System.out.println( w.countObservers() );
    u.acquire( "banana" );
    w.acquire( "carrot" );
    // expect reaction from Observers a and b

  }
}