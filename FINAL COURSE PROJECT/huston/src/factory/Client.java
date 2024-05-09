package factory;
public class Client {
  public static void main(String[] args) {
    Creator a = new ConcreteCreatorA();
    a.anOperation();

    Creator b = new ConcreteCreatorB();
    b.anOperation();
  }
}