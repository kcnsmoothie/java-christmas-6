package christmas;

import christmas.controller.Controller;
import christmas.service.Service;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Service Service = new Service();

        Controller Controller = new Controller(inputView, outputView, Service);

        Controller.run();
    }
}
