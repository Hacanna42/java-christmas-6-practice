package christmas.domain.promotion.giveaway;

import christmas.dto.GiveawayItemDto;

public interface GiveawayEvent {
    GiveawayItemDto applyGiveaway();
    String getEventName();
}
