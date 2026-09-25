package Array.Sort;

import Array.SearchArray;

public class QuickSort {

    public static <T extends Comparable<T>> void Sort (T[] arr){
        SearchArray.logExecution();
        quickSort(arr,0,arr.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr,low,high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low , int high){
        T pivot = arr[high];

        //Using two pointer i,j
        // here i is of initial state -1 , until a smaller value than pivot is found
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if(arr[j].compareTo(pivot) <= 0){ //checking if the j's value is smaller than pivot
            //  while moving towards pivot index (high)
                i++;

                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place the pivot to its appropiate position by swaping i and high values
        T temp = arr[i+1]; // i + 1 is repositioned pivot's index
        arr[i+1] = arr[high];
        arr[high] = temp;

        //here
        // left to the arr[i+1] are smaller than pivot 
        // roght to the arrr[i+1] are larger than pivot

        return i+1; // return the current index of pivot
    }
    
}
