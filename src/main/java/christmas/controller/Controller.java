package christmas.controller;

import christmas.constant.Menu;
import christmas.service.MenuService;
import christmas.util.Parser;
import christmas.util.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Controller {
    private final InputView inputView; //private final로 설정
    private final OutputView outputView;
    private final MenuService menuService;

    public Controller(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        int date = getDate();
        while (true) {
            try {
                String inputMenuAmount = inputView.inputMenuAmount();
                List<String> parsedMenuAmount = Parser.parseByDelimeter(inputMenuAmount);

                List<String> parsedList = new ArrayList<>();
                for (String str : parsedMenuAmount) {
                    Arrays.stream(str.split("-"))
                            .map(String::trim)
                            .forEach(parsedList::add);
                }

                List<String> menuName = new ArrayList<>();
                for (int i = 0; i < parsedList.size(); i += 2) {
                    menuName.add(parsedList.get(i));
                }

                List<String> strAmount = new ArrayList<>();
                for (int i = 1; i < parsedList.size(); i += 2) {
                    strAmount.add(parsedList.get(i));
                }
                List<Integer> amount = Parser.stringToInt(strAmount);

                Map<Menu, Integer> order = menuService.calculateOrder(menuName, amount);

            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private int getDate() {
        while (true) {
            try {
                String inputDate = inputView.inputDate();
                int intDate = Parser.stringToInt(inputDate);
                Validator.validateNumberRange(intDate);
                return intDate;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
