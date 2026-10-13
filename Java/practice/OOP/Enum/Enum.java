package Enum;

import java.util.Arrays;

enum Status { // here Status is Class
    Running, Failed, Pending, Success;// All these are objects (named Constant) of "Status" class
    // 0-----1-------2--------3
}

public class Enum {

    public static void main(String[] args) {
        Status s = Status.Running;
        // System.out.println(s);

        // // ordinal() - like get Index
        // System.out.println(s.ordinal());

        // // values() - retruns array of Status
        // Status[] arr = Status.values();
        // System.out.println(Arrays.toString(arr));

        s = Status.Pending;

        switch (s) {
            case Running:
                System.out.println("All Good");
                break;
            case Failed:
                System.out.println("Try again");
                break;
            case Pending:
                System.out.println("Please wait");
                break;
            case Success:
                System.out.println("Done");
                break;

            default:
                break;
        }
    }

}
