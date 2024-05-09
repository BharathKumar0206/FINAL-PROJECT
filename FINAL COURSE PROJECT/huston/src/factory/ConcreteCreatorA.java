package factory;

class ConcreteCreatorA extends Creator {
  public Product factoryMethod() {
    return new ConcreteProductA();
  }
}