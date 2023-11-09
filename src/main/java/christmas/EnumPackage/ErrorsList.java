package christmas.EnumPackage;

public enum ErrorsList {
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_DATETYPE("[ERROR] 날짜는 숫자만 입력 가능합니다. 다시 입력해 주세요."),
    INVALID_MENU("[ERROR] 존재하지 않는 메뉴입니다. 다시 입력해 주세요."),
    INVALID_NUMBER("[ERROR] 메뉴는 최소 1개 이상 최대 20이하 까지 주문 가능합니다. 다시 입력해 주세요."),
    INVALID_INPUTNUMBERTYPE("[ERROR] 메뉴의 개수는 숫자 형태로 입력 가능합니다. 다시 입력해 주세요."),

    INVALID_INPUTTYPE("[ERROR] 메뉴의 입력 방식이 잘못 되었습니다. 다시 입력해 주세요."),

    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorsList(String message) {
        this.message = message;
    }

    public String getMessage () {
        return message;
    }

}
