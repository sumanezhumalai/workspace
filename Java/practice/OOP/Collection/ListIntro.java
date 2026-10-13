package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIntro {
    public static void main(String[] args) {
        // Collection<Integer> nums = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(8);
        list.add(5);

        // System.out.println(list.indexOf(2));
        // System.out.println(list.get(3));

        // for (Integer n : nums) {
        // System.out.println(n);
        // }

        Iterator<Integer> values = list.iterator();
        // System.out.println(values.next());

        while (values.hasNext()) {
            System.out.println(values.next());
        }
    }
}
