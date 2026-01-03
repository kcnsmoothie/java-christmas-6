package christmas.constant;

public enum ViewMessage {
    ORDER_MENU(" %d개"),
    CHRISTMAS_DC("크리스마스 디데이 할인: %d원"),
    WEEK_OR_WEEKEND_DC("평일 할인: %d원"),
    SPECIAL_DC("특별 할인: %d원"),
    GIFT_DC("증정 이벤트: %d원");

    private final String viewMessage;

    ViewMessage(String inputMessage) {
        this.viewMessage = inputMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public String getViewMessage(int value) {
        return String.format(viewMessage, value);
    }

    public String getViewMessage(double value) {
        return String.format(viewMessage, value);
    }
}
