package prototype;

public class PrototypeDemo {
   public static void initializePrototypes() {    // 3. Populate the "registry"
      PrototypesModule.addPrototype( new This() );
      PrototypesModule.addPrototype( new That() );
      PrototypesModule.addPrototype( new TheOther() );
   }
   public static void main( String[] args ) {
      initializePrototypes();
      Object[] objects = new Object[9];
      int      total   = 0;
      for (int i=0; i < args.length; i++) {     // 6. Client does not use "new"
         objects[total] = PrototypesModule.findAndClone( args[i] );
         if (objects[total] != null) total++; }
      for (int i=0; i < total; i++) ((Command)objects[i]).execute();
	}
}