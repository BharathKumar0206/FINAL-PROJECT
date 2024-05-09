package bridge;
// Purpose.  Bridge design pattern
// 1. Create an implementation/body base class
// 2. Derive the separate implementations from the common abstraction
// 3. Create an interface/wrapper class that "hasa" and delegates to the impl
// 4. Embellish the interface class with derived classes if desired

class BridgeDemo {
   public static void main( String[] args ) {
      Stack[] stacks = { new StackHanoi("java"), new StackHanoi("mine") };
      for (int i=0, num; i < 20; i++) {
         num = (int) (Math.random() * 1000) % 40;
         for (int j=0; j < stacks.length; j++) stacks[j].push( num );
      }
      for (int i=0, num; i < stacks.length; i++) {
         while ( ! stacks[i].isEmpty())
            System.out.print( stacks[i].pop() + "  " );
         System.out.println();
      }
      System.out.println( "total rejected is "
         + ((StackHanoi)stacks[3]).reportRejected() );
}  }