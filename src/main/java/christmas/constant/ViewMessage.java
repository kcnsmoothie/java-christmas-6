package christmas.constant;

public enum ViewMessage {
    ORDER_MENU(" %d개");

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
