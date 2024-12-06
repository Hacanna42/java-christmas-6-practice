package christmas.config;

import christmas.domain.MenuItem;
import christmas.domain.MenuType;
import java.util.ArrayList;
import java.util.List;

public class MenuInitializer {
    public static List<MenuItem> getMenu() {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("양송이수프", 6000, MenuType.APPETIZER));
        menuItems.add(new MenuItem("타파스", 5500, MenuType.APPETIZER));
        menuItems.add(new MenuItem("시저샐러드", 8000, MenuType.APPETIZER));

        menuItems.add(new MenuItem("티본스테이크", 55000, MenuType.MAIN));
        menuItems.add(new MenuItem("바비큐립", 54000, MenuType.MAIN));
        menuItems.add(new MenuItem("해산물파스타", 35000, MenuType.MAIN));
        menuItems.add(new MenuItem("크리스마스파스타", 25000, MenuType.MAIN));

        menuItems.add(new MenuItem("초코케이크", 15000, MenuType.DESSERT));
        menuItems.add(new MenuItem("아이스크림", 5000, MenuType.DESSERT));

        menuItems.add(new MenuItem("제로콜라", 3000, MenuType.BEVERAGE));
        menuItems.add(new MenuItem("레드와인", 60000, MenuType.BEVERAGE));
        menuItems.add(new MenuItem("샴페인", 25000, MenuType.BEVERAGE));

        return menuItems;
    }
}
