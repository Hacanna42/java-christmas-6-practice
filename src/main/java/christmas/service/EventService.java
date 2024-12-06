package christmas.service;

import christmas.domain.MenuBoard;
import christmas.domain.MenuItem;
import christmas.domain.OrderStatus;
import christmas.domain.VisitDate;
import christmas.domain.promotion.discount.day.ChristmasDayDiscountEvent;
import christmas.domain.promotion.discount.day.DayDiscountEvent;
import christmas.domain.promotion.discount.day.SpecialDayDiscountEvent;
import christmas.domain.promotion.discount.menu.HolidayMenuDiscountEvent;
import christmas.domain.promotion.discount.menu.MenuDiscountEvent;
import christmas.domain.promotion.discount.menu.WeekdayMenuDiscountEvent;
import christmas.domain.promotion.giveaway.ChampagneGiveawayEvent;
import christmas.domain.promotion.giveaway.GiveawayEvent;
import christmas.dto.GiveawayItemDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventService {
    public OrderStatus getOrderStatus(Map<String, Integer> parsedOrder) {
        MenuBoard menuBoard = MenuBoard.getMenuBoard();
        Map<MenuItem, Integer> orderedMenu = new HashMap<>();
        for (Map.Entry<String, Integer> entry : parsedOrder.entrySet()) {
            String menuName = entry.getKey();
            int orderAmount = entry.getValue();
            orderedMenu.put(menuBoard.getMenu(menuName), orderAmount);
        }

        return new OrderStatus(orderedMenu);
    }

    public List<GiveawayItemDto> getGiveawayMenus(OrderStatus orderStatus) {
        List<GiveawayEvent> giveawayEvents = List.of(
                new ChampagneGiveawayEvent(orderStatus.getTotalPrice())
        );

        List<GiveawayItemDto> giveawayItems = new ArrayList<>();
        for (GiveawayEvent event : giveawayEvents) {
            giveawayItems.add(event.applyGiveaway());
        }

        return giveawayItems.stream().filter(item -> item.amount() > 0).toList();
    }

    public Map<String, Integer> getPromotionDetails(VisitDate visitDate, OrderStatus orderStatus) {
        List<MenuDiscountEvent> menuDiscountEvents = List.of(
                new WeekdayMenuDiscountEvent(),
                new HolidayMenuDiscountEvent()
        );
        List<DayDiscountEvent> dayDiscountEvents = List.of(
                new ChristmasDayDiscountEvent(),
                new SpecialDayDiscountEvent()
        );
        List<GiveawayEvent> giveawayEvents = List.of(
                new ChampagneGiveawayEvent(orderStatus.getTotalPrice())
        );

        Map<String, Integer> promotionDetails = new HashMap<>();
        for (MenuDiscountEvent event : menuDiscountEvents) {
            int discountedPrice = orderStatus.getDiscountedPriceAfterApply(visitDate, event);
            if (discountedPrice != 0) {
                promotionDetails.put(event.getEventName(), discountedPrice);
            }
        }
        for (DayDiscountEvent event : dayDiscountEvents) {
            int discountedPrice = event.applyDiscount(visitDate).discountedPrice();
            if (discountedPrice != 0) {
                promotionDetails.put(event.getEventName(), discountedPrice);
            }
        }
        for (GiveawayEvent event : giveawayEvents) {
            GiveawayItemDto giveawayItemDto = event.applyGiveaway();
            if (giveawayItemDto.amount() < 1) {
                continue;
            }

            promotionDetails.put(event.getEventName(), giveawayItemDto.price());
        }

        return promotionDetails;
    }
}
