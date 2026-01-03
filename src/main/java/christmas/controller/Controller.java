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
        List<String> parsedMenuAmountList = getMenuAmount();
        List<String> menuName = getMenuName(parsedMenuAmountList);
        List<Integer> amount = getAmount(parsedMenuAmountList);
        Map<Menu, Integer> order = menuService.calculateOrder(menuName, amount);
        outputView.printOrderMenu(order);
        outputView.printBeforeDcTotal();
        int beforeDcTotal = menuService.calculateBeforeDcTotal(order);
        System.out.println(beforeDcTotal + "원");

        int christmasDc = menuService.calculateChristmasDc(date);
        int dayDc = menuService.calculateWeekOrWeekend(date, order);
        int specialDc = menuService.calculateSpecialDc(date);
        int giftMenu = menuService.calculateGiftMenu(beforeDcTotal);

        int totalDc = christmasDc + dayDc + specialDc;

        String giftMenuStr = "없음";
        if (giftMenu != 0) {
            giftMenuStr = "샴페인 1개";
            totalDc -= 25000;
        }

        int afterDcTotal = beforeDcTotal - totalDc;

        outputView.printGiftMenu(giftMenuStr);
        outputView.printBenefit(christmasDc, dayDc, specialDc, giftMenu);
        outputView.printBenefitAmount(totalDc);
        outputView.printAfterDcTotal(afterDcTotal);
        outputView.printDecemberEventBadge();
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

    private List<String> getMenuAmount() {
        while (true) {
            try {
                String inputMenuAmount = inputView.inputMenuAmount();
                List<String> parsedMenuAmount = Parser.parseByDelimeter(inputMenuAmount);
                List<String> parsedMenuAmountList = new ArrayList<>();
                for (String str : parsedMenuAmount) {
                    Arrays.stream(str.split("-"))
                            .map(String::trim)
                            .forEach(parsedMenuAmountList::add);
                }
                return parsedMenuAmountList;




            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<String> getMenuName(List<String> parsedMenuAmountList) {
        while (true) {
            try {
                List<String> menuName = new ArrayList<>();
                for (int i = 0; i < parsedMenuAmountList.size(); i += 2) {
                    menuName.add(parsedMenuAmountList.get(i));
                }
                return menuName;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> getAmount(List<String> parsedMenuAmountList) {
        while (true) {
            try {
                List<String> strAmount = new ArrayList<>();
                for (int i = 1; i < parsedMenuAmountList.size(); i += 2) {
                    strAmount.add(parsedMenuAmountList.get(i));
                }
                List<Integer> amount = Parser.stringToInt(strAmount);
                return amount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
