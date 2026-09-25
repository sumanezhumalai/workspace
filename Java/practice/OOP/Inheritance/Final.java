package Inheritance;

//final in inheritance

final class A { // final Class doent allow inheritance and doent haave child/sub classes
    public A() {
        System.out.println("in A");
    }
}

class B /* extends A */ { // throws error if extend A (which is final)
    public B() {
        System.out.println("in B");
    }

}

public class Final {

    public static void main(String[] args) {
        // A objA = new A();
        B objB = new B();

        System.err.println("\n");
        System.out.println(objB.getClass());
    }
}
