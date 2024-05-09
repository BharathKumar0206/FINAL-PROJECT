package composite;

import java.util.ArrayList;
import java.util.List;

class Box extends Entity {
    private List children = new ArrayList();
    private int  value;
    public Box( int val )       { value = val; }
    public void add( Entity c ) { children.add( c ); }
    public void traverse() {
        System.out.println( indent.toString() + value );
        indent.append( "   " );
        for (int i=0; i < children.size(); i++)
            ((Entity)children.get(i)).traverse();
        indent.setLength( indent.length() - 3 );
	}
}