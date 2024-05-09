package chainOfResponsibility;

class Composite extends Component {
   private Component[] children = new Component[9];
   private int         total    = 0;
   public Composite( int val )              { this( val, null ); }
   public Composite( int val, Component n ) { super( val, n ); }
   public void add( Component c )           { children[total++] = c; }
   public void traverse() {
      super.traverse();                              // 1
      for (int i=0; i < total; i++)                  // |
         children[i].traverse();                     // +-- 2
   }                                                 // |   |
   // 3. Composite objects never handle volunteer    // |   +-- 4 5
   public void volunteer() {            // requests  // |
      super.volunteer();                             // +-- 3
}  }                                                 // |   |