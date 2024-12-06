package christmas;

import christmas.controller.EventController;
import christmas.service.EventService;

public class Application {
    public static void main(String[] args) {
        EventController eventController = new EventController(new EventService());
        eventController.run();
    }
}
