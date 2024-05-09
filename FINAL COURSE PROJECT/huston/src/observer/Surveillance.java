package observer;

// class inheri.  // type inheritance
class Surveillance extends CheckList implements AlarmListener {
   public void alarm() {
      System.out.println( "Surveillance - by the numbers:" );
      byTheNumbers(); }
   protected void isolate() { System.out.println( "   train the cameras" ); }
}