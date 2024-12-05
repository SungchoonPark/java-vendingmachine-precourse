package vendingmachine.exception;

public enum ExceptionMessage {
    COMMON_ERROR("[ERROR] "),

    INVALID_INPUT("유효한 값을 입력해주세요."),
    INVALID_VENDINGMACHINE_MONEY("10원 단위로 나누어지지 않습니다."),

    INVALID_PRODUCT_FORMAT("올바른 상품 형식이 아닙니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return COMMON_ERROR.message + message;
    }
}