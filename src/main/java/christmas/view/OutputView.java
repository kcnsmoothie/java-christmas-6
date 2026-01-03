package christmas.view;

public class OutputView {
    public void printPurchaseResult(int purchaseAmount) {
        System.out.println("<주문 메뉴>");
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
