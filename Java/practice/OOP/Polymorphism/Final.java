
package Polymorphism;

class A extends Object {

    final public void show() { // final method cannot be overridden or changed
        // protects the senstive working mechanism
        System.out.println("from A");
    }

    public void sound() {
        System.out.println("Sound from A");
    }
}

class B extends A {

    /*
     * @Override
     * public void show() { // throws error - Cannot override the final method from
     * A
     * System.out.println("from B");
     * }
     */

    @Override
    public void sound() { // non-final method can be overriden
        System.out.println("Sound from B");
    }
}

public class Final {
    public static void main(String[] args) {
        B obj1 = new B();

        obj1.show();
        obj1.sound();

        A obj2 = new B(); // even refrencing wont affect final 
        obj1.show();
    }
}
