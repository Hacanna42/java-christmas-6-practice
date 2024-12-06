package christmas.dto;

public record DiscountPromotionDto(String promotionName, int discountedPrice) {
    public static DiscountPromotionDto nothing() {
        return new DiscountPromotionDto("", 0);
    }
}
