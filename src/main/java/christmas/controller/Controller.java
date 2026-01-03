package christmas.controller;

import christmas.service.Service;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private final InputView inputView; //private final로 설정
    private final OutputView outputView;
    private final Service service;

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        String inputDate = inputView.inputDate();
        inputView.inputMenuAmount();
    }
}
