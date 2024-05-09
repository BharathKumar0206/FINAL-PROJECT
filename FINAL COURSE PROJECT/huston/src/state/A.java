package state;

class A implements State {
   public void on(  FSM fsm ) { System.out.println( "A + on  = C" );
      fsm.changeState( 2 ); }
   public void off( FSM fsm ) { System.out.println( "A + off = B" );
      fsm.changeState( 1 ); }
   public void ack( FSM fsm ) { System.out.println( "A + ack = A" );
      fsm.changeState( 0 ); }
}