package state;

class C implements State {                  // 7. Only override some messages
   public void on( FSM fsm ) { System.out.println( "C + on  = B" );
      fsm.changeState( 1 ); }            // 8. "call back to" the wrapper class
   public void off( FSM fsm ) { System.out.println( "error" ); }
   public void ack( FSM fsm ) { System.out.println( "error" ); }
}