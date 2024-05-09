package visitor;

interface Visitor {
  void visit( Leaf l );
  void visit( Composite c );
}