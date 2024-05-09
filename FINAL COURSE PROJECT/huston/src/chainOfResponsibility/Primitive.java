package chainOfResponsibility;

class Primitive extends Component {
   public Primitive( int val )              { this( val, null ); }
   public Primitive( int val, Component n ) { super( val, n ); }
   public void volunteer() {
      super.traverse();
      // 3. Primitive objects don't handle volunteer requests 5 times out of 6
      if ((int)(Math.random()*100) % 6 != 0)
         // 3. Delegate to the base class
         super.volunteer();
}  }