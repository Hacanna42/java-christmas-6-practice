package christmas.domain.promotion.discount.day;

import christmas.domain.VisitDate;
import christmas.dto.DiscountPromotionDto;

public class ChristmasDayDiscountEvent implements DayDiscountEvent {
    @Override
    public DiscountPromotionDto applyDiscount(VisitDate visitDate) {
        if (visitDate.getMonth() != 12 || visitDate.getDay() > 25) {
            return DiscountPromotionDto.nothing();
        }

        int discountedPrice = 1000 + ((visitDate.getDay() - 1) * 100);
        return new DiscountPromotionDto("크리스마스 디데이 할인", discountedPrice);
    }

    @Override
    public String getEventName() {
        return "크리스마스 디데이 할인";
    }
}
