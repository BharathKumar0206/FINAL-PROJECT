package composite;

class Product extends Entity {
    private int value;
    public Product( int val ) { value = val; }
    public void traverse() {
        System.out.println( indent.toString() + value );
}   }