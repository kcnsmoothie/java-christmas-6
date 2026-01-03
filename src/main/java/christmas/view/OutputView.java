package christmas.view;

import static christmas.constant.ViewMessage.ORDER_MENU;

import christmas.constant.Menu;
import java.util.Map;
import java.util.Objects;

public class OutputView {
    public void printOrderMenu(Map<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.print(entry.getKey().getName());
                System.out.println(ORDER_MENU.getViewMessage(entry.getValue()));
            }
        }
    }

    public void printBeforeDcTotal() {
        System.out.println("<할인 전 총주문 금액>");
    }

    public void printGiftMenu() {
        System.out.println("<증정 메뉴>");
    }

    public void printBenefit() {
        System.out.println("<혜택 내역>");
    }

    public void printBenefitAmount() {
        System.out.println("<총혜택 금액>");
    }

    public void printAfterDcTotal() {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    public void printDecemberEventBadge() {
        System.out.println("<12월 이벤트 배지>");
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
