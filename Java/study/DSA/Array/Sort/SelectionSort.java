package Array.Sort;

import Array.SearchArray;

public class SelectionSort {

    // Generic sort: works for any type T that implements Comparable (Integer, String, User, etc.)
    public static <T extends Comparable<T>> void Sort(T[] arr) {
        SearchArray.logExecution();
        
        // i divides array into [sorted | unsorted]
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i; // assume first unsorted element is minimum

            // scan unsorted portion to find actual minimum
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0){ // found a smaller element
                    minIndex = j;
                }
            }

            // swap only if minimum is not already in place
            if(minIndex != i){
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}