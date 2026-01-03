package christmas.constant;

public enum ErrorMessage {
    DEFAULT_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DATE_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final static String ANNOTATE_ERROR = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String inputMessage) {
        this.errorMessage = inputMessage;
    }

    public String getErrorMessage() {
        return ANNOTATE_ERROR + errorMessage;
    }
}
