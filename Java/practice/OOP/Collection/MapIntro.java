package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(); // unordered and no duplicates

        map.put("Suman", 2);
        map.put("Sham", 3);
        map.put("Kiran", 7);
        map.put("Priyam", 8);
        map.put("Kiran", 6);

        // System.out.println(map);
        // System.out.println(map.get("Suman"));

        Iterator<String> values = (map.keySet()).iterator();

        while (values.hasNext()) {
            String key = values.next();
            System.out.println("Key : " + key + " Values: " + map.get(key));
        }

        // for (String key : students.keySet()) {
        //     System.out.println(key + ":" + students.get(key));
        // }
    }
}
