package state;
public class StateDemo2 {
   public static void main( String[] args ) {
      FSM   fsm  = new FSM();
      int[] msgs = { 2, 1, 2, 1, 0, 2, 0, 0 };
      for (int i=0; i < msgs.length; i++)
         if      (msgs[i] == 0) fsm.on();
         else if (msgs[i] == 1) fsm.off();
         else if (msgs[i] == 2) fsm.ack();
	}
}