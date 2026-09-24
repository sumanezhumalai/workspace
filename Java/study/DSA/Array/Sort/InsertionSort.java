package Array.Sort;

import Array.SearchArray;

public class InsertionSort {
    public static <T extends Comparable<T>> void Sort ( T[] arr){
        SearchArray.logExecution();
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }
     
}
