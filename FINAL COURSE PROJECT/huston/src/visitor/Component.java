package visitor;

interface Component {
  void traverse();
  void accept( Visitor v );
}