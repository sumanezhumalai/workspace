package MultiThread;

public class RaceCondition {
    static int count;

    public static synchronized void incrementCount() { // synchronized - prevents any race conditions - so we het exact
                                                       // operations value . eg: 2000
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable obj = () -> { // since Runnable is an funtional interface with only run() method , We used
            // Lambda function here

            for (int i = 0; i < 1000; i++) {
                incrementCount();

                // try {
                // Thread.sleep(10);
                // } catch (InterruptedException e) {

                // e.printStackTrace();
                // }
            }

        };

        Runnable obj1 = () -> {
            for (int i = 0; i < 1000; i++) {
                incrementCount();

                // try {
                // Thread.sleep(10);
                // } catch (InterruptedException e) {

                // e.printStackTrace();
                // }
            }

        };

        Thread t1 = new Thread(obj); // Thread constructor can take an Runnable Object (ctrl + click on "Thread"
                                     // class to inspect)
        Thread t2 = new Thread(obj1);

        t1.start();
        t2.start();

        // tells the main to wait for t1 or t2 before moving onto next - but not
        // guarenteed
        // thread cab be unpredictable
        t1.join();
        t2.join();

        System.out.println(count);
    }
}
