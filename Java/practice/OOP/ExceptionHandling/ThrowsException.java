package ExceptionHandling;

//throws just passes the responsibility of handling an Exception to its Caller function / Up the stack

class A {
    public void show() throws ClassNotFoundException {
        // try
        // {
        // Class.forName("Calc");
        // }
        // catch(ClassNotFoundException e)
        // {
        // System.out.println("Not able to find the class");
        // }

        Class.forName("Calc");
    }
}

public class ThrowsException {

    static {
        System.out.println("Class Loader");
    }

    public static void main(String[] args) { // Never use throws at main() , it'll just throw the exception to JVM and
                                             // JVM will not Handle but stops the Execution!

        // try
        // {
        // Class.forName("Class");
        // }
        // catch(ClassNotFoundException e)
        // {
        // System.out.println("Not able to find theh class");
        // }

        A obj = new A();
        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}