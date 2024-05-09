package composite;

public class CompositeLevels {
    public static void main( String[] args ) {
        Box root = initialize();
        root.traverse();
    }

    private static Box initialize() {
        Box[] nodes = new Box[7];
        nodes[1] = new Box( 1 );
        int[] s = { 1, 4, 7 };
        for (int i=0; i < 3; i++) {
            nodes[2] = new Box( 21+i );
            nodes[1].add( nodes[2] );
            int lev = 3;
            for (int j=0; j < 4; j++) {
                nodes[lev-1].add( new Product( lev*10 + s[i] ) );
                nodes[lev] = new Box( lev*10 + s[i]+1 );
                nodes[lev-1].add( nodes[lev] );
                nodes[lev-1].add( new Product( lev*10 + s[i]+2 ) );
                lev++;
        	}
        }
        return nodes[1];
	}   
}