import java.util.Arrays;

public class ArrayBasics {
    public static void main(String[] args) {
        // declare + init forms
        int[] a = new int[3]; // {0,0,0}, length fixed
        int[] b = {1, 2, 3};
        int[] c = new int[]{4, 5};
        int d[] = {6}; // C-style, avoid
        System.out.println(a.length + " " + b.length); // length is field, not method

        // defaults: 0, 0.0, false, '\u0000', null
        String[] s = new String[2];
        System.out.println(s[0]); // null

        // index 0..length-1, else ArrayIndexOutOfBoundsException
        b[0] = 99;
        System.out.println(b[0] + " " + b[b.length - 1]);

        // iterate: classic (need index) vs enhanced (read-only)
        for (int i = 0; i < b.length; i++) System.out.print(b[i] + " ");
        System.out.println();
        for (int v : b) System.out.print(v + " ");
        System.out.println();

        // 2D: rows x cols, row-major
        int[][] m = new int[2][3];
        int[][] m2 = {{1, 2}, {3, 4}};
        System.out.println(m.length + "x" + m[0].length); // 2x3

        // jagged: rows can differ, must init each row
        int[][] jag = new int[2][];
        jag[0] = new int[]{1};
        jag[1] = new int[]{2, 3};
        System.out.println(Arrays.deepToString(jag));

        // builtins (java.util.Arrays)
        int[] n = {3, 1, 2};
        Arrays.sort(n); // in-place
        System.out.println(Arrays.toString(n)); // [1, 2, 3], print directly else hash
        System.out.println(Arrays.binarySearch(n, 2)); // index, needs sorted
        System.out.println(Arrays.equals(n, new int[]{1, 2, 3})); // true, == compares refs

        int[] f = new int[3];
        Arrays.fill(f, 7); // {7,7,7}
        int[] cp = Arrays.copyOf(n, 5); // {1,2,3,0,0}, pads/truncates
        int[] rg = Arrays.copyOfRange(n, 1, 3); // {2,3}
        System.out.println(Arrays.toString(f) + Arrays.toString(cp) + Arrays.toString(rg));

        int[] src = {1, 2, 3};
        int[] dst = new int[3];
        System.arraycopy(src, 0, dst, 0, 3); // fast native copy
        System.out.println(Arrays.toString(dst));

        // int[] x = new int[-1]; // NegativeArraySizeException
        // int[] y = null; y.length; // NullPointerException
    }
}
