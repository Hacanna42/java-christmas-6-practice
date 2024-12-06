package christmas.controller;

import christmas.domain.OrderStatus;
import christmas.domain.VisitDate;
import christmas.dto.GiveawayItemDto;
import christmas.service.EventService;
import christmas.util.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public void run() {
        OutputView.printWelcomeMessage();
        VisitDate visitDate = getVisitDate();
        OrderStatus orderStatus = getOrder();
        printOrderStatus(visitDate, orderStatus);
    }

    private static VisitDate getVisitDate() {
        return VisitDate.initFrom(InputView.getExpectedVisitDate());
    }

    private OrderStatus getOrder() {
        String input = InputView.getOrderMenuAndAmount();
        return eventService.getOrderStatus(Parser.parseOrder(input));
    }

    private void printOrderStatus(VisitDate visitDate, OrderStatus orderStatus) {
        OutputView.printPreviewPromotionMessage();
        OutputView.printOrderedMenu(orderStatus.getOrderedMenu());
        OutputView.printTotalPriceWithoutPromotion(orderStatus.getTotalPrice());

        OutputView.printGiveawayItems(eventService.getGiveawayMenus(orderStatus));
        OutputView.printPromotionDetails(eventService.getPromotionDetails(visitDate, orderStatus), orderStatus.getTotalPrice());
    }
}
