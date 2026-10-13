package Class.Types;

/**
 * InnerClass
 */

class A {
    int age;

    public void show() {
        System.out.println("in A");
    }

    static class B {
        public void config() {
            System.out.println("in B");
        }
    }

}

public class InnerClass {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();
        System.out.println(obj.age);

        // A.B obj1 = obj.new B(); //when the inner class is non static
        // obj1.config();

        A.B obj1 = new A.B(); // if the inner class in Static class
        obj1.config();
    }

}