package Array;
import java.util.Comparator;

import Model.User;
import Seed.UserSeed;
import Array.Sort.BubbleSort;
import Array.Sort.HeapSort;
import Array.Sort.InsertionSort;
import Array.Sort.MergeSort;
import Array.Sort.QuickSort;
import Array.Sort.SelectionSort;

public class SearchArray {

    private static User[] users = UserSeed.getUsers();
    

    public static void Display (int index , String target){
        System.out.printf("the target %s is found at position %d ",target,index + 1);
    }

    public static void logExecution(){
        StackWalker walker = StackWalker.getInstance();

        walker.walk(frames -> frames.skip(1).findFirst())
            .ifPresent(frame -> System.out.println("Executing: " + frame.getMethodName() + "()" + 
                " from Class: " + frame.getClassName()));

    }

    //Linear Search
    public static int LinearSearch(User[] users, String target){
        logExecution();
        for (int i = 0; i < users.length; i++) {
            if(users[i].getName() == target){
                logExecution();
                return i;
            }
        }
        return -1;
    }

    //Sentinel Linear Search  (reduces check condition)
    public static int SentinalSearch (User[] users, String target){
        logExecution();
        int n = users.length;
        String actualValue = users[n-1].getName();

        users[n-1].setName(target) ;
        int i = 0;

        while(!users[i].getName().equals(target)){
            i++;
        }

        users[n-1].setName(actualValue);

        if( i < n - 1 || users[n-1].getName().equals(target)){
            
            return i;
        }

        return -2;
    }

    //BinarySearch
    // public static int BinarySearch(User[] users, String target, int left , int right){
    //     if(left > right) { logExecution(); return -1};

    //     int mid = left + (right - left) / 2;
    //     if(target.equals(users[mid].getPhone())) {
    //         logExecution();
    //         return mid;
    //     }
    //     else if(target.compareTo(users[mid].getPhone()) > 0){
    //         return BinarySearch(users, target, mid+1, right);
    //     }
    //     else {
    //         return BinarySearch(users, target, left, mid-1);
    //     }
    // }
    
    //Binary Search - iterative approach
    public static int BinarySearch(User[] users, String target, int left , int right){
        logExecution();

        while (left <= right ) {
            int mid = left + (right - left) / 2;

            if (users[mid].getPhone().equals(target) ) { return mid;}

            if(users[mid].getPhone().compareTo(target) > 0){
                right = mid - 1 ;
            }else{
                left = mid + 1 ;
            }
        }

        return -2;
    }



    public static void main(String[] args) {

        System.out.println("\n"+ "Before Sorting ->"+ "\n");

        for (User val : users) {
            System.out.println(val.toString());
        }

        System.out.println("\n\n");

        //Linear Search
        // Display(LinearSearch(SearchArray.users,"User4"),"User4");

        //Sentinal Search (reduces check condition)
        // Display(SentinalSearch(SearchArray.users,"User4"),"User4");

        //Binary Search

            //Merge Sort
            // MergeSort<User> sorter = new MergeSort<>(); // We use Generic Class here , so creating Object
            // sorter.Sort(users,Comparator.comparing(User::getPhone));

            //Bubble Sort
            // BubbleSort.Sort(users);

            //Selection Sort
            // SelectionSort.Sort(users);

            //Insertion Sort
            InsertionSort.Sort(users);

            //Heap Sort
            // HeapSort.Sort(users);

            //QuickSort
            // QuickSort.Sort(users);

            System.out.println("After Sorting ->"+ "\n");
            for (User val : users) {
                System.out.println(val.toString());
            }

            System.out.println("\n\n" + "Searching..." + "\n");
            Display(LinearSearch(users,"009"),"009");
    }
}
