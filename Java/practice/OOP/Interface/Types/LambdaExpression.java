package Interface.Types;

/**
 * A
 */
@FunctionalInterface
interface A {
    int add(int a, int b);
}

public class LambdaExpression {
    public static void main(String[] args) {
        // A obj = new A() {
        // public int add(int a, int b) {
        // return (a + b);
        // }
        // };

        A obj = (a, b) -> a + b; // no need name "add" , coz funtional interface has only one method rule "add"

        System.out.println(obj.add(2, 3)); // so this work with lamda expression + functional interface
    }
}
