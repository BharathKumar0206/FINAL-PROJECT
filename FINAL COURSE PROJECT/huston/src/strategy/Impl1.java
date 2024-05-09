package strategy;

class Impl1 extends TemplateMethod1 {
   private int state = 1;
   protected void    start()   { System.out.print( "start  " ); }
   protected void    stop()    { System.out.println( "stop" ); }
   protected boolean nextTry() {
      System.out.print( "nextTry-" + state++ + "  " );
      return true; }
   protected boolean isSolution() {
      System.out.print( "isSolution-" + (state == 3) + "  " );
      return (state == 3);
	}  
}