package factory;

abstract class Creator {
  abstract public Product factoryMethod();
  public void anOperation() {
    Product p = this.factoryMethod();
    System.out.println(p.getName() + "???????");
  }
}