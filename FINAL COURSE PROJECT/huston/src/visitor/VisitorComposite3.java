package visitor;
import java.util.*;

public class VisitorComposite3 {
  public static void main( String[] args ) {
    Composite[] containers = new Composite[3];

    for (int i=0; i < containers.length; i++) {
      containers[i] = new Composite();
      for (int j=1; j < 4; j++)
        containers[i].add( new Leaf( i * containers.length + j ) );
    }

    for (int i=1; i < containers.length; i++)
      containers[0].add( containers[i] );

    containers[0].traverse();
    System.out.println();

    CollectVisitor anOperation = new CollectVisitor();
    containers[0].accept( anOperation );
    System.out.print( "letters are - " + anOperation.getLetters() );
    System.out.println( ", numbers are - " + anOperation.getNumbers() );
	}
}