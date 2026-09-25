public class Loops {
    public static void main(String[] args) {
        // classic for: init; cond; update (any part optional)
        for (int i = 0; i < 3; i++) System.out.print(i + " "); // 0 1 2
        System.out.println();

        // init outside, update inside
        int j = 0;
        for (; j < 3;) { System.out.print(j + " "); j++; }
        System.out.println();

        // for (;;) = infinite, break to exit
        for (int k = 0;; k++) { if (k >= 2) break; System.out.print(k + " "); }
        System.out.println();

        // while: check first, may run 0 times
        int w = 0;
        while (w < 2) { System.out.print(w + " "); w++; }
        System.out.println();

        // do-while: runs at least once (; required)
        int d = 5;
        do { System.out.print(d + " "); d++; } while (d < 5);
        System.out.println();

        // enhanced for: read-only over array, no index
        int[] a = {10, 20, 30};
        for (int v : a) System.out.print(v + " ");
        System.out.println();
        // for (int v : a) v = 0; // no effect on array

        // break vs continue
        for (int i = 0; i < 5; i++) {
            if (i == 1) continue; // skip 1
            if (i == 3) break; // stop at 3
            System.out.print(i + " ");
        }
        System.out.println();

        // labeled break/continue for nested loops
        outer:
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (c > r) continue outer;
                if (r == 2 && c == 1) break outer;
                System.out.print(r + "" + c + " ");
            }
        }
        System.out.println();
    }
}
