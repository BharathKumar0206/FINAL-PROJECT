package strategy;
public class StrategyDemo {    // 4. Clients couple strictly to the interface
   public static void clientCode( Strategy strat ) { strat.solve(); }
   
   private static Strategy strat;
   public static void main( String[] args ) {
      Strategy[] algorithms = { new Impl1(), new Impl2() };
      for (int i=0; i < algorithms.length; i++) {
		Strategy strat1 = strat=algorithms[i];
		strat1.solve();
      }
	}
}