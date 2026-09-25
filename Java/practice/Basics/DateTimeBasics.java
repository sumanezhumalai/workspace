import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeBasics {
    public static void main(String[] args) {
        // current date/time (immutable)
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(date + " " + time + " " + dt);

        // create specific: of(year, month, day)
        LocalDate d = LocalDate.of(2026, 9, 25);
        LocalTime t = LocalTime.of(10, 30);
        System.out.println(d + " " + t);

        // parse/format with pattern
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(d.format(f)); // 25-09-2026
        System.out.println(LocalDate.parse("25-09-2026", f));

        // arithmetic returns new object
        System.out.println(d.plusDays(1) + " " + d.minusMonths(1));

        // getters, compare
        System.out.println(d.getYear() + " " + d.getDayOfWeek());
        System.out.println(d.isBefore(date) + " " + d.isAfter(date));
    }
}
