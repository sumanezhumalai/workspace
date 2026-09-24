package Array.Sort;
import Model.User;
import java.util.function.ToIntFunction;

/**
 * CountingSort
 */
public class CountingSort {

    public static <T extends Comparable<T>> void Sort (T[] arr, ToIntFunction<T> keyExtractor){
            int min = keyExtractor.applyAsInt(arr[0]);
            int max = min;

            for (T t : arr) {

            }

    }
    
}
·