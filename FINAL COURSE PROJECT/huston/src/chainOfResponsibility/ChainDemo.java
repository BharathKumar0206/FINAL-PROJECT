package chainOfResponsibility;

                                                         // |   +-- 6 7
	public class ChainDemo {                             // |
	   public static void main( String[] args ) {        // +-- 8 9
	      Component seven = new Primitive( 7 );          // 
	      Component six   = new Primitive( 6, seven );   // tra: 1 2 4 5 3 6 7 8 9
	      Composite three = new Composite( 3, six );     // 4
	      three.add( six );  three.add( seven );         // 4 5 6 7
	      Component five  = new Primitive( 5, three );   // 4 5 6 7 8 9
	      Component four  = new Primitive( 4, five );    // 4 5 6 7 8
	      Composite two   = new Composite( 2, four );    // 4 5 6 7
	      two.add( four );   two.add( five );            // 4 5 6 7 8 9 4 5 6 7
	      Composite one   = new Composite( 1, two );     // 4
	      Component nine  = new Primitive( 9, one );     // 4 5 6 7 8 9 4 5 6 7 8
	      Component eight = new Primitive( 8, nine );
	      one.add( two );  one.add( three );  one.add( eight );  one.add( nine );
	      seven.setNext( eight );
	      System.out.print( "tra: " );  one.traverse();  System.out.println();
	      for (int i=0; i < 8; i++) {
	         one.volunteer();  System.out.println();
	}  }  }

