package Array.Sort;

import java.util.Comparator;

import Array.SearchArray;
import Model.User;
import Seed.UserSeed;

public class MergeSort <T> {

    /*
     * MergeSort: Divide array into halves, sort recursively, merge sorted halves.
     * Time: O(n log n) all cases | Space: O(n) | Stable: Yes | In-place: No
     */
    public void Sort(T[] arr, Comparator<T> comp) {
        SearchArray.logExecution();
        mergeSort(arr, 0, arr.length - 1, comp); // start with full range
    }

    private void mergeSort(T[] arr, int l, int r, Comparator<T> comp) {
        if (l < r) {
            int mid = l + (r - l) / 2;  // avoid overflow vs (l+r)/2
            mergeSort(arr, l, mid, comp);    // sort left half
            mergeSort(arr, mid + 1, r, comp); // sort right half
            merge(arr, l, mid, r, comp);     // merge sorted halves
        }
    }

    private void merge(T[] arr, int l, int m, int r, Comparator<T> comp) {
        int n1 = m - l + 1;   // left subarray size
        int n2 = r - m;       // right subarray size

        @SuppressWarnings("unchecked")
        T[] L = (T[]) new Comparable[n1]; // temporary left array
        @SuppressWarnings("unchecked")
        T[] R = (T[]) new Comparable[n2]; // temporary right array

        for(int i = 0 ; i < n1 ; i++ ){ // copy data to temp arrays
            L[i] = arr[l+i];
        }
        for(int j = 0 ; j < n2 ; j++ ){
            R[j] = arr[m+j+1];
        }

        // merge two sorted halves back into arr[l..r]
        int i = 0; // left index
        int j = 0; // right index
        int k = l; // merged index

        while ( i < n1 && j < n2){
            if(comp.compare(L[i], R[j]) < 0){ // left is smaller
                arr[k] = L[i];
                i++;
                k++;
            }else{ // right is smaller or equal (stable)
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while ( i < n1){ // copy remaining left elements
            arr[k] = L[i];
            i++;k++;
        }
        while ( j < n2){ // copy remaining right elements
            arr[k] = R[j];
            j++;k++;
        }

    }
}