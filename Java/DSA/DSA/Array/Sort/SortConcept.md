# Sorting Algorithms — Quick Reference

## Comparison Table

| Algorithm | Best | Average | Worst | Space | Stable | In-Place |
|-----------|------|---------|-------|-------|--------|----------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes | ✅ Yes |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | ❌ No | ✅ Yes |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes | ✅ Yes |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ Yes | ❌ No |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | ❌ No | ✅ Yes |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ No | ✅ Yes |

---

## 1. Bubble Sort

**Idea:** Repeatedly compare adjacent elements and swap if out of order. Largest element "bubbles up" to the end each pass.

```
[5,3,8,1] → compare 5>3, swap → [3,5,8,1]
           → compare 5<8, keep → [3,5,8,1]
           → compare 8>1, swap → [3,5,1,8]  ← 8 bubbled to end
           → repeat for remaining...
```

- **Best O(n):** Already sorted + `swapped` flag optimization — one pass, no swaps, exit early.
- **When to use:** Small arrays, nearly sorted data, or when simplicity matters.
- **Key trait:** Compares only adjacent elements.

---

## 2. Selection Sort

**Idea:** Divide array into `[sorted | unsorted]`. Find minimum in unsorted portion, swap it to the boundary.

```
[5,3,8,1] → find min=1 at index 3, swap with index 0 → [1,3,8,5]
[1 | 3,8,5] → find min=3 at index 1, already in place → [1,3,8,5]
[1,3 | 8,5] → find min=5 at index 3, swap with index 2 → [1,3,5,8]
```

- **Always O(n²):** Always scans full unsorted portion regardless of input.
- **When to use:** When you want minimum number of swaps (useful for write-sensitive media).
- **Key trait:** Makes exactly `n-1` swaps. Unstable because swapping can change relative order.

---

## 3. Insertion Sort

**Idea:** Build sorted portion one element at a time. Pick next element, shift larger elements right, insert in correct position.

```
[5,3,8,1] → key=3, shift 5 right → [3,5,8,1]
[3,5 | 8,1] → key=8, already in place → [3,5,8,1]
[3,5,8 | 1] → key=1, shift 8,5,3 right → [1,3,5,8]
```

- **Best O(n):** Already sorted — inner while loop never executes.
- **When to use:** Small arrays, nearly sorted data, or as base case in hybrid sorts (like TimSort).
- **Key trait:** Like sorting playing cards in hand. Adaptive — benefits from existing order.

---

## 4. Merge Sort

**Idea:** Divide array into halves recursively until single elements. Merge sorted halves back together.

```
[5,3,8,1] → split → [5,3] [8,1]
                      ↓       ↓
                    [3,5]   [1,8]   ← sorted individually
                      ↓       ↓
                    merge → [1,3,5,8]
```

- **Always O(n log n):** Consistent performance regardless of input.
- **When to use:** Large arrays, linked lists, external sorting (disk files), or when stability matters.
- **Key trait:** Requires O(n) extra space for temp arrays during merge. Stable — equal elements keep original order.

---

## 5. Heap Sort

**Idea:** Build a max-heap from array. Repeatedly extract maximum (root) and place at end.

```
[5,3,8,1] → build max-heap → [8,3,5,1]
           → swap root 8 to end → [1,3,5 | 8]
           → heapify [1,3,5] → [5,3,1 | 8]
           → swap root 5 to end → [1,3 | 5,8]
           → ... → [1,3 | 5,8] → [1 | 3,5,8] → [1,3,5,8]
```

- **Always O(n log n):** Heap operations are O(log n), done n times.
- **When to use:** When you need guaranteed O(n log n) with O(1) space (unlike Merge Sort).
- **Key trait:** In-place + same time as Merge Sort but not stable. Build phase is O(n), extraction is O(n log n).

---

## 6. Quick Sort

**Idea:** Pick a pivot. Partition array so smaller elements go left, larger go right. Recurse on both halves.

```
[5,3,8,1] → pivot=1 (last element)
            → partition: [1 | 5,3,8] (pivot at index 0)
            → recurse on right: [5,3,8] → pivot=8
            → partition: [5,3 | 8]
            → recurse on left: [5,3] → pivot=3
            → partition: [3 | 5]
            → done → [1,3,5,8]
```

- **Best/Avg O(n log n):** Pivot splits evenly.
- **Worst O(n²):** Bad pivot choices (already sorted array with first/last pivot).
- **When to use:** General-purpose. Fastest in practice due to cache locality.
- **Key trait:** In-place, but not stable. O(log n) recursion stack space.

---

## When to Use What

| Scenario | Best Choice | Why |
|----------|-------------|-----|
| Small array (n < 50) | Insertion Sort | Low overhead, simple |
| Nearly sorted | Insertion Sort or Bubble Sort | Adaptive — O(n) best case |
| Large array, need stability | Merge Sort | O(n log n) guaranteed + stable |
| Large array, memory constrained | Heap Sort or Quick Sort | In-place |
| General purpose | Quick Sort | Fastest average, cache-friendly |
| Linked list | Merge Sort | No random access needed, stable |
| External sorting (files on disk) | Merge Sort | Works with sequential access |

---

## Generic Implementation

### How It Works

All sorts use `<T extends Comparable<T>>` — a **bounded type parameter**:

```java
public static <T extends Comparable<T>> void Sort(T[] arr)
```

- **`<T>`** — declares a generic type T (can be Integer, String, User, etc.)
- **`extends Comparable<T>`** — T must implement `Comparable<T>`, meaning it has a `compareTo()` method
- This ensures `arr[i].compareTo(arr[j])` is valid for any T

### Why `Comparable<T>`?

Java doesn't know how to compare arbitrary objects. You must tell it:
- `int` uses `<` and `>`
- Objects use `compareTo()` which returns negative, zero, or positive

```java
// For Integer/Double — already implement Comparable
Integer[] nums = {5, 3, 8};
BubbleSort.Sort(nums);  // works out of box

// For custom class — must implement Comparable
class User implements Comparable<User> {
    public int compareTo(User other) {
        return this.name.compareTo(other.name); // define order
    }
}
```

### Merge Sort: `Comparator<T>` (Different Approach)

MergeSort uses `Comparator<T>` instead of requiring `Comparable`:

```java
public void Sort(T[] arr, Comparator<T> comp)
```

- **`Comparator<T>`** — external comparison logic, passed as argument
- More flexible: same type can be sorted differently without modifying its class

```java
// Sort by name
obj.Sort(users, (a, b) -> a.getName().compareTo(b.getName()));

// Sort by phone
obj.Sort(users, (a, b) -> a.getPhone().compareTo(b.getPhone()));
```

### `Comparable` vs `Comparator`

| | `Comparable` | `Comparator` |
|--|-------------|-------------|
| Where | Inside the class | External / lambda |
| Method | `compareTo(T o)` | `compare(T a, T b)` |
| Modifies class | Yes | No |
| Multiple orderings | No (one natural order) | Yes (pass different comparators) |
| Used by | BubbleSort, Selection, Insertion, Heap, Quick | MergeSort (in this codebase) |

### Why `(T[]) new Comparable[n]`?

Generic array creation is illegal in Java: `new T[n]` won't compile. Workaround:

```java
T[] L = (T[]) new Comparable[n1]; // create Comparable array, cast to T[]
```

- Creates `Comparable` array (which can hold any `Comparable` objects)
- Casts to `T[]` for type safety
- `@SuppressWarnings("unchecked")` silences the unavoidable cast warning
- Safe because `T extends Comparable<T>` guarantees all T objects are Comparable
