package christmas.domain;

import java.util.Objects;

public class MenuItem {
    private final String name;

    private final int price;

    private final MenuType menuType;

    public MenuItem(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public boolean isSameName(String name) {
        return Objects.equals(this.name, name);
    }

    public boolean isMainMenu() {
        return menuType == MenuType.MAIN;
    }

    public boolean isDessertMenu() {
        return menuType == MenuType.DESSERT;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
