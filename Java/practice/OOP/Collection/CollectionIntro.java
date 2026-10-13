package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionIntro {

    public static void main(String[] args) {
        Collection<Integer> nums = new ArrayList<Integer>();

        nums.add(6);
        nums.add(2);
        nums.add(8);
        nums.add(5);

        for (Integer n : nums) {
            System.out.println(n);
        }
    }
}

/*
 * Java Collection Framework Hierarchy Tree
 * 
 * Legend:
 * (I) = Interface
 * (A) = Abstract Class
 * (C) = Concrete Class
 * --> = Extends / Implements
 *
 * Iterable (I)
 * └── Collection (I)
 * ├── List (I)
 * │ ├── AbstractList (A)
 * │ │ ├── ArrayList (C)
 * │ │ └── Vector (C)
 * │ │ └── Stack (C)
 * │ └── AbstractSequentialList (A)
 * │ └── LinkedList (C) (Also implements Deque)
 * │
 * ├── Queue (I)
 * │ ├── Deque (I) (Double-Ended Queue)
 * │ │ ├── ArrayDeque (C)
 * │ │ └── LinkedList (C) (Also implements List)
 * │ └── PriorityQueue (C)
 * │
 * └── Set (I)
 * ├── AbstractSet (A)
 * │ ├── HashSet (C)
 * │ │ └── LinkedHashSet (C)
 * │ └── EnumSet (A/C)
 * └── SortedSet (I)
 * └── NavigableSet (I)
 * └── TreeSet (C)
 *
 * ───────────────────────────────────────────────────────────────
 * Note: Map is NOT a subtype of Collection, but part of the Framework.
 * ───────────────────────────────────────────────────────────────
 * 
 * Map (I)
 * ├── AbstractMap (A)
 * │ ├── HashMap (C)
 * │ │ └── LinkedHashMap (C)
 * │ ├── IdentityHashMap (C)
 * │ └── WeakHashMap (C)
 * ├── SortedMap (I)
 * │ └── NavigableMap (I)
 * │ └── TreeMap (C)
 * └── Dictionary (A) [Legacy]
 * └── Hashtable (C)
 * └── Properties (C)
 */
