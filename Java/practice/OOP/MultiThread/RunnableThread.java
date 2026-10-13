package MultiThread;

public class RunnableThread {
    public static void main(String[] args) {

        Runnable obj = () -> { // since Runnable is an funtional interface with only run() method , We used
                               // Lambda function here

            for (int i = 0; i < 50; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }

        };

        Runnable obj1 = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }

        };

        Thread t1 = new Thread(obj); // Thread constructor can take an Runnable Object (ctrl + click on "Thread"
                                     // class to inspect)
        Thread t2 = new Thread(obj1);

        t1.start();
        t2.start();
    }
}
