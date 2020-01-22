public class Nil implements ListOfNumber {
  private Nil() { }
  public static Nil EMPTY = new Nil(); 
  public int first() { throw new UnsupportedOperationException(); } 
  public ListOfNumber rest() { throw new UnsupportedOperationException(); } 
}
