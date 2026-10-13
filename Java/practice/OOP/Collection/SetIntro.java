package Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetIntro {
    public static void main(String[] args) {
        // Set<Integer> set = new HashSet<>(); // Set has no duplicates and not Sorted
        Set<Integer> set = new TreeSet<>();// (but TreeSet is sorted)
        set.add(6);
        set.add(2);
        set.add(8);
        set.add(6);
        set.add(2);
        set.add(10);
        
        Iterator<Integer> values = set.iterator();
        // System.out.println(values.next());

        while (values.hasNext()) {
            System.out.println(values.next());
        }
    }
}
