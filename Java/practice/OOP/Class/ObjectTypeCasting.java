package Class;

class A extends Object {

    public void show1() {
        System.out.println("from A");
    }

    public void sound() {
        System.out.println("Sound from A");
    }

}

class B extends A {

    public void show2() {
        System.out.println("from B");
    }
}

public class ObjectTypeCasting {

    public static void main(String[] args) {

        A obj = new B(); // Upcasting
        obj.show1(); // only sees A's method and properties
        obj.sound();
        // obj.show2(); // -> throws error , even through the object is 'B'

        B obj1 = (B) obj; // will show type mismatch without explicit "B" - downcasting (from parent to
        // child type)
        obj1.show1(); // this works coz child B can acces parent A's property and methods.
        obj1.show2();
    }

}
