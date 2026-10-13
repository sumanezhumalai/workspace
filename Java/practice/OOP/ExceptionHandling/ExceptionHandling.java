package ExceptionHandling;
/*
try , catch , throw 
*/

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int dividor = 2;
            int divident = 100;

            float result = divident / dividor;
            System.out.println(result);

            // int[] arr = new int[5];
            // System.out.println(arr[5]);
            // System.out.println(arr[4]);

            boolean execution = true;
            // use throw to explicitly call a exception
            if (execution) {
                throw new CustomException("No more code to Execute in Try{} Block");
            }

        } catch (CustomException e) {
            System.out.println("Exception occured :  " + e);
        } catch (ArithmeticException e) {
            System.out.println("Exception occured :  " + e);
            System.out.println("ALERT: Resolve the Divide be Zero part !");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception occured :  " + e);
            System.out.println("ALERT: Recheck the Accessing index value !");
        } catch (Exception e) {
            System.out.println("Exception occured :  " + e);
        }

        System.out.println("Program comes to an END here !"); // this will be aways executed since we are handling the
                                                              // excpetion
    }
}

/*
 * Object
 * │
 * └── Throwable
 * │
 * ├── Error (Unchecked/Fatal system failures)
 * │ ├── VirtualMachineError
 * │ │ ├── StackOverflowError
 * │ │ └── OutOfMemoryError
 * │ ├── AssertionError
 * │ └── LinkageError
 * │ └── NoClassDefFoundError
 * │
 * └── Exception (Application-level issues)
 * │
 * ├── RuntimeException (Unchecked Exceptions)
 * │ ├── NullPointerException
 * │ ├── IllegalArgumentException
 * │ │ └── NumberFormatException
 * │ ├── ArithmeticException
 * │ └── IndexOutOfBoundsException
 * │ ├── ArrayIndexOutOfBoundsException
 * │ └── StringIndexOutOfBoundsException
 * │
 * └── [Checked Exceptions] (Direct subclasses of Exception)
 * ├── IOException
 * │ ├── FileNotFoundException
 * │ └── SocketException
 * ├── SQLException
 * ├── ClassNotFoundException
 * └── InterruptedException
 * 
 */
