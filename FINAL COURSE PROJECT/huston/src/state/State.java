package state;

interface State {
   public void on(  FSM fsm );
   public void off( FSM fsm );
   public void ack( FSM fsm );
}