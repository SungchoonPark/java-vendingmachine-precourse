package vendingmachine.exception;

public enum ExceptionMessage {
    COMMON_ERROR("[ERROR] ");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return COMMON_ERROR.message + message;
    }
}