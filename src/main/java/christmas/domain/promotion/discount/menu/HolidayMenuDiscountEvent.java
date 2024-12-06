package christmas.domain.promotion.discount.menu;

import christmas.domain.MenuItem;
import christmas.domain.VisitDate;
import christmas.dto.DiscountPromotionDto;

public class HolidayMenuDiscountEvent implements MenuDiscountEvent {
    @Override
    public DiscountPromotionDto applyDiscount(VisitDate visitDate, MenuItem menuItem) {
        if (visitDate.isDecemberHoliday() && menuItem.isMainMenu()) {
            return new DiscountPromotionDto("주말 할인", 2023);
        }

        return DiscountPromotionDto.nothing();
    }

    @Override
    public String getEventName() {
        return "주말 할인";
    }
}
