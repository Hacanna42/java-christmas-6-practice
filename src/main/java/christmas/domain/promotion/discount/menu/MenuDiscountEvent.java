package christmas.domain.promotion.discount.menu;

import christmas.domain.MenuItem;
import christmas.domain.VisitDate;
import christmas.dto.DiscountPromotionDto;

public interface MenuDiscountEvent {
    DiscountPromotionDto applyDiscount(VisitDate visitDate, MenuItem menuItem);
    String getEventName();
}
