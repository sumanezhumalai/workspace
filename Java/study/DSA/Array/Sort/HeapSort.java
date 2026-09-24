package Array.Sort;

import Array.SearchArray;

public class HeapSort {

    public static <T extends Comparable<T>> void Sort (T[] arr){
        SearchArray.logExecution();
        int n = arr.length;
        
        for (int i = ( n/2 -1 ); i >= 0; i--) {
            heapify(arr,n,i); //possible parent node n/2 -1 heapifycation 
        }

        for (int end =  n - 1; end > 0 ; end--) {
            T temp = arr[end];
            arr[end] = arr[0];
            arr[0] = temp;

            heapify(arr, end, 0);
        }
    }

    public static <T extends Comparable<T>> void heapify(T[] arr, int n , int i){
        int largest = i;
        int left = 2*i + 1; // projective left child node
        int right = 2*i + 2; // projective right child node

        if(left < n && arr[left].compareTo(arr[largest]) > 0){
            largest = left;
        }
        
        if(right < n && arr[right].compareTo(arr[largest]) > 0){
            largest = right;
        }

        if(largest != i){ //swap the new largest to the root
            T temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);// continue heapifycation with new root
        } 
    }
}
