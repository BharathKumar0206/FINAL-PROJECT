package prototype;

// 5. Sign-up for the clone()
class This implements Prototype, Command {        //    contract.  Each class 
   public Object clone()   { return new This(); } //    calls "new" on itself
   public String getName() { return "This"; }     //    FOR the client.
   public void   execute() { System.out.println( "This: execute" ); }
}