package christmas.Model;

public enum ErrorsList {
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("[ERROR] 존재하지 않는 메뉴입니다. 다시 입력해 주세요."),
    INVALID_NUMBER("[ERROR] 메뉴는 최대 20개까지 주문 가능합니다. 다시 입력해 주세요."),
    INVALID_INPUT("[ERROR] 메뉴의 개수는 숫자 형태로 입력 가능합니다. 다시 입력해 주세요.");

    private final String message;



}
