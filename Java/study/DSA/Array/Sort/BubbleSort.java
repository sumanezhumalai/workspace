package Array.Sort;

import Array.SearchArray;

public class BubbleSort {

    /*
     * BubbleSort: Repeatedly compare & swap adjacent elements.
     * Time: O(n²) avg/worst, O(n) best (already sorted)
     * Space: O(1) | Stable: Yes | In-place: Yes
     */
    public static <T extends Comparable<T>> void Sort(T[] arr) {
        SearchArray.logExecution();
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    swapped = true;
                }
            }
            if (!swapped) break; // optimized: exit if already sorted
        }
    }

}
