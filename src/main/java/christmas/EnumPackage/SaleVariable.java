package christmas.EnumPackage;

public enum SaleVariable {
    CHRISTMAS_SALE("크리스마스 디데이 할인"),
    WEEKDAY_SALE("평일 할인"),
    WEEKEND_SALE("주말 할인"),
    SPECIAL_SALE("특별 할인"),
    PRESENT_SALE("증정 이벤트");

    private String message;

    SaleVariable(String message) {
        this.message = message;
    }

    public String getMessage () {
        return this.message;
    }

}
