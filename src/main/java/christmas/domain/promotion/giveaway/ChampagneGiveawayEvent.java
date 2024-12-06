package christmas.domain.promotion.giveaway;

import christmas.dto.GiveawayItemDto;

public class ChampagneGiveawayEvent implements GiveawayEvent {
    private final boolean condition;

    public ChampagneGiveawayEvent(int totalPrice) {
        condition = totalPrice > 120000;
    }

    public GiveawayItemDto applyGiveaway() {
        if (!condition) {
            return new GiveawayItemDto("", 0, 0);
        }

        return new GiveawayItemDto("샴페인", 1, 25000);
    }

    @Override
    public String getEventName() {
        return "증정 이벤트";
    }
}
