package Inheritance;


class A extends Object { // eevry class in java inherits object class bu default
  public A() {
    System.out.println("in A");
  }

  public A(int x) {
    System.out.println(x + " in A");
  }
}

class B extends A {
  public B() {
    super(2);
    System.out.println("in B");
  }

  public B(int y) {

    this();
    System.out.println(y + " in B");
  }
}

public class Super {

  public static void main(String[] args) {
    // A objA = new A();
    B objB = new B(2);

    System.err.println("\n");
    System.out.println(objB.getClass());
  }
}
