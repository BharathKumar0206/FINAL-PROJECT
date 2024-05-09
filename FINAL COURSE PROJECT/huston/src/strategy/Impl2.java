package strategy;

class Impl2 extends TemplateMethod2 {
   private int state = 1;
   protected void    preProcess()  { System.out.print( "preProcess  " ); }
   protected void    postProcess() { System.out.print( "postProcess  " ); }
   protected boolean search() {
      System.out.print( "search-" + state++ + "  " );
      return state == 3 ? true : false;
	}
}