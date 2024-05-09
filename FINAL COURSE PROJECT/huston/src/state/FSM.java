package state;

class FSM {                                                 // 1. The "wrapper"
   private State[] states  = { new A(), new B(), new C() }; // 2. States array
   private int     current = 0;                             // 3. Current state
   public void on()  { states[current].on(  this ); }       // 4. Delegation
   public void off() { states[current].off( this ); }       //    and pass the
   public void ack() { states[current].ack( this ); }       //    this pointer
   public void changeState( int index ) { current = index; }
}