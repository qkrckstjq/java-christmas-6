package christmas.Model;

public enum PrintContentTitleList {
    ORDER_MENU("<주문 메뉴>"),
    BEFORE_SALE("<할인 전 총 주문 금액>"),
    PRESENTATION_MENU("<증정 메뉴>"),
    BENEFIT("<혜택 내역>"),
    TOTAL_BENEFIT("<총혜택 내역>"),
    AFTER_SALE("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>");

    private final String message;
    PrintContentTitleList(String message) {
        this.message = message;
    }

    public String getMessage () {
        return message;
    }
}
