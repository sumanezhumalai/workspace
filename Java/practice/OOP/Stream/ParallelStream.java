package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
    public static void main(String[] args) {

        int size = 1_000;
        List<Integer> nums = new ArrayList<>(size);
        Random rdm = new Random();

        for (int i = 1; i <= size; i++) {
            nums.add(rdm.nextInt(100));
        }

        // int total = nums.stream()
        // .map(n -> n * 2)
        // .reduce(0, (c,e) -> c + e);

        long startSeq = System.currentTimeMillis(); // this tracks Unix time as the total number of seconds
                                                    // that have passed since January 1, 1970, at 00:00:00 UTC, ignoring
                                                    // leap seconds

        int total = nums.stream()
                // .mapToInt(n -> n * 2) // or we could write .map(n -> n*2 ).mapToInt(n -> n)
                .mapToInt(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return n = n * 2;
                })
                .sum();

        long endSeq = System.currentTimeMillis();
        // ----------------

        long startParallel = System.currentTimeMillis();

        int parallelTotal = nums.parallelStream()
                // .mapToInt(n -> n * 2) // or we could write .map(n -> n*2 ).mapToInt(n -> n)
                .mapToInt(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return n = n * 2;
                })
                .sum();
        long endParallel = System.currentTimeMillis();

        System.out.println("Total Sequencial Execution : " + total + " Time : " + (endSeq - startSeq));
        System.out.println("Total Parallel Execution : " + parallelTotal + " Time : " + (endParallel - startParallel));
        // System.out.print(nums);
    }
}
