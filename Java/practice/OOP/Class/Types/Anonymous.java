package Class.Types;

/**
 * Anonymous
 */

class A {
    int age;

    public void show() {
        System.out.println("in A");
    }

}

// class B {
// public void show() {
// System.out.println("in B");
// }
// }

public class Anonymous {

    public static void main(String[] args) {
        A obj = new A() { // anonymous inner class - no clas name at all
            public void show() {
                System.out.println("in Anonymous");
            }
        };

        obj.show();
    }

}