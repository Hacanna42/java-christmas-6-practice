package christmas.domain;

import christmas.config.MenuInitializer;
import java.util.List;

public class MenuBoard {
    private final List<MenuItem> menuItems;

    private MenuBoard(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public static MenuBoard getMenuBoard() {
        return new MenuBoard(MenuInitializer.getMenu());
    }

    public boolean has(String menuName) {
        return menuItems.stream().anyMatch(menuItem -> menuItem.isSameName(menuName));
    }

    public MenuItem getMenu(String menuName) {
        if (!has(menuName)) {
            throw new IllegalArgumentException("[ERROR] 이름에 맞는 메뉴를 찾을 수 없음.");
        }

        return menuItems.stream().filter(menuItem -> menuItem.isSameName(menuName)).findFirst().get();
    }
}
