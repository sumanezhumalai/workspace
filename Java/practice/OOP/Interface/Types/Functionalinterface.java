package Interface.Types;

//also knows as SAM -> Single Abstarct Method Interface
/**
 * A
 */

// @FunctionalInterface
interface A {
    void show();
}

public class Functionalinterface {
    public static void main(String[] args) {
        A obj = new A() { // we couls refer , as well as instantite by anonymous class //wide used java 7
                          // feature
            public void show() {
                System.out.println("in Show anonymous");
            }
        };

        obj.show();

    }
}
