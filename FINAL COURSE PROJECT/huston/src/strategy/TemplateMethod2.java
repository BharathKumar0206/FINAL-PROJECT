package strategy;

abstract class TemplateMethod2 implements Strategy { // 2. Bury implementation
   public void solve() {                             // 3. Template Method
      while (true) {
         preProcess();
         if (search()) break;
         postProcess();
   	  }  
   }
   protected abstract void    preProcess();
   protected abstract boolean search();
   protected abstract void    postProcess();
}