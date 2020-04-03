package name.electricalqzhang.test;

public enum ConfirmStatus {
    UNCONFIRMED(0, "未确认"),
    CONFIRMED(1, "已确认"),
    IGNORE(2, "忽略"),
    INVALID(3,"无效");

    private final Integer code;
    private final String message;

    ConfirmStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ConfirmStatus getByCode(int code) {
        for (ConfirmStatus s : ConfirmStatus.values()) {
            if (s.code == code) {
                return s;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
