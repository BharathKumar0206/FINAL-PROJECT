package visitor;

class Leaf implements Component {
  private int number;
  public Leaf( int num )          { number = num; }
  public void traverse()          { System.out.print( number + " " ); }
  public void accept( Visitor v ) { v.visit( this ); }
  public int  getNumber()         { return number; }
}