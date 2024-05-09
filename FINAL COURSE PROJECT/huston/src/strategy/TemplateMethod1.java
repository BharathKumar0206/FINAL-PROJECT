package strategy;

//    of the algorithm
abstract class TemplateMethod1 implements Strategy { // 2. Bury implementation
   public void solve() {                             // 3. Template Method 
      start();
      while (nextTry() && ! isSolution())
         ;
      stop();
   }
   protected abstract void    start();
   protected abstract boolean nextTry();
   protected abstract boolean isSolution();
   protected abstract void    stop();
}