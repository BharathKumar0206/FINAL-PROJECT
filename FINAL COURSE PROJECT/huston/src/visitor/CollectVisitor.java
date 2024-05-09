package visitor;

class CollectVisitor implements Visitor {
  private StringBuffer letters = new StringBuffer();
  private StringBuffer numbers = new StringBuffer();

  public void   visit( Composite c ) { letters.append( c.getLetter() ); }
  public void   visit( Leaf l )      { numbers.append( l.getNumber() ); }
  public String getLetters()         { return letters.toString(); }
  public String getNumbers()         { return numbers.toString(); }
}