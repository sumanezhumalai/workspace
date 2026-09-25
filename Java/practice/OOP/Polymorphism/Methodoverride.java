package Polymorphism;

class A extends Object {

  public void show() {
    System.out.println("from A");
  }

  public void sound() {
    System.out.println("Sound from A");
  }
}

class B extends A {
  @Override
  public void show() {
    System.out.println("from B");
  }
}

public class Methodoverride {
  public static void main(String[] args) {
    B objB = new B();
    objB.show();
    objB.sound();
  }
}
