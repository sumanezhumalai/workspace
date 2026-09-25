public class SwitchDemo {
    public static void main(String[] args) {
        int day = 3;

        // classic: fall-through without break, default anywhere (convention: last)
        switch (day) {
            case 1: System.out.println("Mon"); break;
            case 2: System.out.println("Tue"); break;
            case 3: System.out.println("Wed"); break;
            default: System.out.println("other");
        }

        // fall-through grouping
        switch (day) {
            case 1: case 2: case 3: case 4: case 5:
                System.out.println("weekday"); break;
            case 6: case 7:
                System.out.println("weekend"); break;
            default: System.out.println("invalid");
        }

        // arrow syntax (no fall-through, no break needed)
        switch (day) {
            case 1 -> System.out.println("Mon");
            case 2, 3 -> System.out.println("Tue/Wed");
            default -> System.out.println("other");
        }

        // switch expression + yield (must be exhaustive or have default)
        String name = switch (day) {
            case 1 -> "Mon";
            case 2 -> "Tue";
            case 3 -> { yield "Wed"; } // yield for block body
            default -> "other";
        };
        System.out.println(name);

        // classic-style expression with : and yield
        String type = switch (day) {
            case 1, 2, 3, 4, 5: yield "weekday";
            case 6, 7: yield "weekend";
            default: yield "invalid";
        };
        System.out.println(type);

        // String switch (case-sensitive), null throws NPE
        String lang = "java";
        switch (lang) {
            case "java": System.out.println("jvm"); break;
            case "c": System.out.println("native"); break;
            default: System.out.println("unknown");
        }
        // switch (null) -> NullPointerException
    }
}
