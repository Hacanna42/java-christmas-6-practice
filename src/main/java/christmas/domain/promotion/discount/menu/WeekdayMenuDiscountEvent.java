package christmas.domain.promotion.discount.menu;

import christmas.domain.MenuItem;
import christmas.domain.VisitDate;
import christmas.dto.DiscountPromotionDto;

public class WeekdayMenuDiscountEvent implements MenuDiscountEvent {
    @Override
    public DiscountPromotionDto applyDiscount(VisitDate visitDate, MenuItem menuItem) {
        if (!visitDate.isDecemberHoliday() && menuItem.isDessertMenu()) {
            return new DiscountPromotionDto("평일 할인", 2023);
        }

        return DiscountPromotionDto.nothing();
    }

    @Override
    public String getEventName() {
        return "평일 할인";
    }
}
