package chainOfResponsibility;

abstract class Component {
   private int       value;
   private Component next;             // 1. "next" pointer in the base class
   public Component( int v )              { this( v, null ); }
   public Component( int v, Component n ) { value = v;  next = n; }
   public void setNext( Component n )     { next = n; }
   public void traverse()                 { System.out.print( value + " " ); }
   // 2. The "chain" method in the base class always delegates to the next obj
   public void volunteer()                { next.volunteer(); }
}