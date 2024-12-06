package christmas.domain.promotion.discount.day;

import christmas.domain.VisitDate;
import christmas.dto.DiscountPromotionDto;
import java.util.List;

public class SpecialDayDiscountEvent implements DayDiscountEvent {
    private final List<Integer> eventDays = List.of(3, 10, 17, 24, 25, 31);

    @Override
    public DiscountPromotionDto applyDiscount(VisitDate visitDate) {
        if (visitDate.getMonth() == 12 && eventDays.contains(visitDate.getDay())) {
            return new DiscountPromotionDto("특별 할인", 1000);
        }

        return DiscountPromotionDto.nothing();
    }

    @Override
    public String getEventName() {
        return "특별 할인";
    }
}
