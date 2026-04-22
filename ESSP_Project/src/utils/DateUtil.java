package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String today() {
        return LocalDate.now().toString();
    }

    public static String format(LocalDate date) {
        DateTimeFormatter fmt =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return date.format(fmt);
    }

    public static boolean isPastDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }
}