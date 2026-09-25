public class MathBasics {
    public static void main(String[] args) {
        // constants
        System.out.println(Math.PI + " " + Math.E);

        // abs, max, min (overloads for int/long/float/double)
        System.out.println(Math.abs(-5) + " " + Math.max(3, 7) + " " + Math.min(3, 7));

        // power, roots
        System.out.println(Math.pow(2, 10)); // 1024.0, returns double
        System.out.println(Math.sqrt(16)); // 4.0, NaN if negative
        System.out.println(Math.cbrt(27)); // 3.0

        // rounding: ceil up, floor down, round half-up, rint half-even
        System.out.println(Math.ceil(2.1) + " " + Math.floor(2.9)); // 3.0 2.0
        System.out.println(Math.round(2.5) + " " + Math.round(2.4)); // 3 2

        // random [0.0, 1.0), int range via (int)(Math.random() * n)
        System.out.println((int) (Math.random() * 10)); // 0-9

        // trig/log/exp take radians
        System.out.println(Math.sin(Math.PI / 2)); // 1.0
        System.out.println(Math.log(Math.E) + " " + Math.exp(1)); // 1.0 ~2.718
    }
}
