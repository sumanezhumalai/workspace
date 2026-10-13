package Interface;

/**
 * A
 */
// cannot be instantiated , only be refrenced
interface A { // by default
    int rate = 2; // All variable in a interface is final and static

    void show(); // All methods in a interface are public and abstract

    void config();
}

/**
 * Y
 */
interface Y {
    void run();
}

/**
 * X
 */
interface X extends Y {
    void stop();
}

/**
 * A
 */
class B implements A, X {

    public void show() {
        System.out.println("in B show");
    }

    public void config() {
        System.out.println("in B config");
    }

    public void run() {
        System.out.println("Running by X");
    }

    public void stop() {
        System.out.println("Stopping by X");
    }
}

public class Interface {

    public static void main(String[] args) {
        A obj; // interface reference
        obj = new B();
        obj.show();
        obj.config();

        // A.rate = 6;// The final field A.rate cannot be assigned , also cannoy be
        // assigned in static
        // way by "obj"
        System.out.println(obj.rate);
        System.out.println(A.rate);

        // obj.run(); wont work because A is still thre reference , not X
    }

}
