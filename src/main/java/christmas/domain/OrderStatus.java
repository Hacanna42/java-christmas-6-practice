package christmas.domain;

import christmas.domain.promotion.discount.menu.MenuDiscountEvent;
import java.util.HashMap;
import java.util.Map;

public class OrderStatus {
    private final Map<MenuItem, Integer> orderedMenu;

    public OrderStatus(Map<MenuItem, Integer> orderedMenu) {
        this.orderedMenu = orderedMenu;
    }

    public int getDiscountedPriceAfterApply(VisitDate visitDate, MenuDiscountEvent event) {
        int totalDiscount = 0;
        for (Map.Entry<MenuItem, Integer> entry : orderedMenu.entrySet()) {
            MenuItem menuItem = entry.getKey();
            int orderAmount = entry.getValue();
            totalDiscount += event.applyDiscount(visitDate, menuItem).discountedPrice() * orderAmount;
        }

        return totalDiscount;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<MenuItem, Integer> entry : orderedMenu.entrySet()) {
            MenuItem menuItem = entry.getKey();
            int orderAmount = entry.getValue();
            totalPrice += menuItem.getPrice() * orderAmount;
        }

        return totalPrice;
    }

    public Map<String, Integer> getOrderedMenu() {
        Map<String, Integer> orderedMenu = new HashMap<>();
        for (Map.Entry<MenuItem, Integer> entry : this.orderedMenu.entrySet()) {
            String itemName = entry.getKey().getName();
            int orderAmount = entry.getValue();
            orderedMenu.put(itemName, orderAmount);
        }

        return orderedMenu;
    }
}
