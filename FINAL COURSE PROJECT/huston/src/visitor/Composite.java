package visitor;

import java.util.ArrayList;
import java.util.List;

class Composite implements Component {
  private static char next = 'a';
  private List children = new ArrayList();
  private char letter = next++;

  public void add( Component c ) { children.add( c ); }
  public void traverse() {
    System.out.print( letter + " " );
    for (int i=0; i < children.size(); i++)
      ((Component)children.get(i)).traverse();
  }
  public void accept( Visitor v ) {
    v.visit( this );
    for (int i=0; i < children.size(); i++)
      ((Component)children.get(i)).accept( v );
  }
  public char getLetter() { return letter; }
}