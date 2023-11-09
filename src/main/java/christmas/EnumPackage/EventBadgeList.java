package christmas.EnumPackage;

public enum EventBadgeList {
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private String message;

    EventBadgeList(String message) {
        this.message = message;
    }

    public String getMessage () {
        return this.message;
    }

    public static String getBadge (int number) {
        if(number >= 5000 && number < 10000) {
            return EventBadgeList.STAR.getMessage();
        } else if (number >= 10000 && number < 20000) {
            return EventBadgeList.TREE.getMessage();
        } else if (number >= 20000) {
            return EventBadgeList.SANTA.getMessage();
        }
        return "없음";
    }

}
