package christmas.domain.promotion.discount.day;

import christmas.domain.VisitDate;
import christmas.dto.DiscountPromotionDto;

public interface DayDiscountEvent {
    DiscountPromotionDto applyDiscount(VisitDate visitDate);
    String getEventName();
}
