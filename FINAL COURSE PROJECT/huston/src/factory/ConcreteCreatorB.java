package factory;

class ConcreteCreatorB extends Creator {
  public Product factoryMethod() {
    return new ConcreteProductB();
  }
}