public class Element implements ListOfNumber {
  private int first; 
  private ListOfNumber rest;
  public Element(int number, ListOfNumber lon) {
    this.first = number; 
    this.rest = lon; 
  }
  public int first() { return this.first; }
  public ListOfNumber rest() { return this.rest; } 
}