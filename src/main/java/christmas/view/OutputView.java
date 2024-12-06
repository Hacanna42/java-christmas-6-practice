package christmas.view;

import christmas.dto.GiveawayItemDto;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printPreviewPromotionMessage() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printOrderedMenu(Map<String, Integer> orderedMenu) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            String name = entry.getKey();
            int amount = entry.getValue();
            System.out.printf("%s %d개%n", name, amount);
        }
        System.out.println();
    }

    public static void printTotalPriceWithoutPromotion(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원%n%n", totalPrice);
    }

    public static void printGiveawayItems(List<GiveawayItemDto> giveawayItems) {
        System.out.println("<증정 메뉴>");
        if (giveawayItems.isEmpty()) {
            System.out.println("없음\n");
            return;
        }

        for (GiveawayItemDto giveawayItemDto : giveawayItems) {
            System.out.printf("%s %d개%n", giveawayItemDto.name(), giveawayItemDto.amount());
        }
        System.out.println();
    }

    public static void printPromotionDetails(Map<String, Integer> promotionDetails, int totalPrice) {
        int totalDiscountedPrice = 0;
        System.out.println("<혜택 내역>");
        if (promotionDetails.isEmpty()) {
            System.out.println("없음");
        }
        for (Map.Entry<String, Integer> entry : promotionDetails.entrySet()) {
            System.out.printf("%s: -%,d원%n", entry.getKey(), entry.getValue());
            totalDiscountedPrice += entry.getValue();
        }
        System.out.println();

        System.out.println("<총혜택 금액>");
        if (totalDiscountedPrice > 0) {
            System.out.print("-");
        }
        System.out.printf("%,d%n", totalDiscountedPrice);
        System.out.println();

        int finalPrice = totalPrice - totalDiscountedPrice;

        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n", finalPrice);
        System.out.println();

        System.out.println("<12월 이벤트 배지>");
        if (totalDiscountedPrice >= 20000) {
            System.out.println("산타");
            return;
        }
        if (totalDiscountedPrice >= 10000) {
            System.out.println("트리");
            return;
        }
        if (totalDiscountedPrice >= 5000) {
            System.out.println("별");
            return;
        }

        System.out.println("없음");
    }
}
