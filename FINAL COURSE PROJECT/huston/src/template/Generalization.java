package template;

abstract class Generalization {
   // 1. Standardize the skeleton of an algorithm in a "template" method
   public void findSolution() {
      stepOne();
      stepTwo();
      stepThr();
      stepFor();
   }
   // 2. Common implementations of individual steps are defined in base class
   protected void stepOne() { System.out.println( "Generalization.stepOne" ); }
   // 3. Steps requiring peculiar impls are "placeholders" in the base class
   abstract protected void stepTwo();
   abstract protected void stepThr();
   protected void stepFor() { System.out.println( "Generalization.stepFor" ); }
}