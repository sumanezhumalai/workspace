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

class C extends B {
    @Override
    public void show() {
        System.out.println("from C");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        // A obj = new B(); // --> referneces/typed through parent / superclass
        // obj.show();

        A obj = new A();
        obj.show();

        obj = new B();
        obj.show();

        obj = new C();
        obj.show();

        // same A type object dynamically/runtime dtermines the appropriate working
        // method
        // Thus called DynamicMethodDispatch
    }
}
