public class StringBufferDemo {
    public static void main(String[] args) {
        // mutable + synchronized (thread-safe, slower) -> same API as Builder
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb.capacity()); // 19

        sb.append(123).append(' ').append(true);
        sb.insert(0, ">");
        System.out.println(sb);

        sb.delete(0, 1);
        sb.deleteCharAt(0);
        sb.replace(0, 3, "XY");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.reverse();

        System.out.println(sb.charAt(0) + " " + sb.length());
        sb.setCharAt(0, 'Z');
        sb.setLength(3);
        System.out.println(sb);

        // rule: String (immutable, few concats) vs Builder (loops, single thread)
        // vs Buffer (shared across threads only)
        StringBuffer pre = new StringBuffer(100);
        pre.ensureCapacity(200);
        pre.trimToSize();
        System.out.println(pre.capacity());

        String done = sb.toString();
        System.out.println(done);
        sb.setLength(0);
        System.out.println("cleared:" + sb.length());
    }
}
