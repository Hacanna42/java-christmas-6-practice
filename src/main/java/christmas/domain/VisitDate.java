package christmas.domain;

import christmas.message.ErrorMessage;
import java.util.List;

public class VisitDate {
    private static final int CHRISTMAS_PROMOTION_MONTH = 12;
    private static final List<Integer> HOLIDAYS = List.of(1, 2, 8, 9, 15, 16, 29, 30);

    private final int month;
    private final int day;

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private VisitDate(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static VisitDate initFrom(String day) {
        validate(day);
        return new VisitDate(CHRISTMAS_PROMOTION_MONTH, Integer.parseInt(day));
    }

    public boolean isDecemberHoliday() {
        return month == 12 && HOLIDAYS.contains(day);
    }

    private static void validate(String day) {
        try {
            int parsedDay = Integer.parseInt(day);
            if (!(parsedDay >= 1 && parsedDay <= 31)) {
                throw new IllegalArgumentException(ErrorMessage.DATE_INVALID.getMessage());
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.DATE_INVALID.getMessage());
        }
    }
}
