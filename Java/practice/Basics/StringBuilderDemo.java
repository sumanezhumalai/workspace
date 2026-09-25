public class StringBuilderDemo {
    public static void main(String[] args) {
        // mutable, non-synchronized (faster) -> default for single thread
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb.capacity()); // 16 + len = 19

        // append/insert (chainable), no new object
        sb.append(123).append(' ').append(true);
        sb.insert(0, ">");
        System.out.println(sb);

        // delete, replace, reverse
        sb.delete(0, 1); // [start, end)
        sb.deleteCharAt(0);
        sb.replace(0, 3, "XY");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.reverse();

        // access + mutate in place
        System.out.println(sb.charAt(0) + " " + sb.length());
        sb.setCharAt(0, 'Z');
        sb.setLength(3); // truncates (or pads with \u0000 if grown)
        System.out.println(sb);

        // capacity: auto-grows (old*2+2), pre-size to avoid copies
        StringBuilder pre = new StringBuilder(100);
        pre.ensureCapacity(200);
        pre.trimToSize(); // shrink to length
        System.out.println(pre.capacity());

        // toString to freeze, compare via toString().equals()
        String done = sb.toString();
        System.out.println(done + " " + sb.substring(0, 2));

        // indexOf/delete range, setLength(0) fastest clear
        System.out.println(sb.indexOf("Z") + " " + sb.lastIndexOf("Z"));
        sb.setLength(0);
        System.out.println("cleared:" + sb.length());
    }
}
