package christmas.view;

import static christmas.constant.ViewMessage.CHRISTMAS_DC;
import static christmas.constant.ViewMessage.GIFT_DC;
import static christmas.constant.ViewMessage.ORDER_MENU;
import static christmas.constant.ViewMessage.SPECIAL_DC;
import static christmas.constant.ViewMessage.WEEK_DC;

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

    public void printGiftMenu(String giftMenuStr) {
        System.out.println("<증정 메뉴>");
        System.out.println(giftMenuStr);
    }

    public void printBenefit(int christmasDc, int dayDc, int specialDc, int giftMenu) {
        System.out.println("<혜택 내역>");
        if (christmasDc != 0) {
            System.out.println(CHRISTMAS_DC.getViewMessage(christmasDc));
        }
        if (dayDc != 0) {
            System.out.println(WEEK_DC.getViewMessage(christmasDc));
        }
        if (specialDc != 0) {
            System.out.println(SPECIAL_DC.getViewMessage(specialDc));
        }
        if (giftMenu != 0) {
            System.out.println(GIFT_DC.getViewMessage(-25000));
        }
        System.out.println("없음");
    }

    public void printBenefitAmount(int totalDc) {
        System.out.println("<총혜택 금액>");
        System.out.println(totalDc + "원");
    }

    public void printAfterDcTotal(int afterDcTotal) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(afterDcTotal + "원");
    }

    public void printDecemberEventBadge() {
        System.out.println("<12월 이벤트 배지>");
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
