package christmas.util;

import christmas.domain.MenuItem;
import christmas.domain.OrderStatus;
import christmas.message.ErrorMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public static Map<String, Integer> parseOrder(String input) {
        Map<String, Integer> orderStatus = new HashMap<>();
        for (String order : List.of(input.split(","))) {
            try {
                List<String> list = List.of(order.split("-"));
                if (list.size() != 2) {
                    throw new IllegalArgumentException(ErrorMessage.MENU_INVALID.getMessage());
                }

                String menuName = list.get(0);
                int menuAmount = Integer.parseInt(list.get(1));

                if (orderStatus.containsKey(menuName)) {
                    throw new IllegalArgumentException(ErrorMessage.MENU_INVALID.getMessage());
                }

                orderStatus.put(menuName, menuAmount);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException(ErrorMessage.MENU_INVALID.getMessage());
            }
        }

        return orderStatus;
    }
}
