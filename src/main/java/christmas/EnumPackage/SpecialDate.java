package christmas.EnumPackage;

public enum SpecialDate {
    DAY_3(3),
    DAY_10(10),
    DAY_17(17),
    DAY_24(24),
    DAY_25(25),
    DAY_31(31);

    private final int date;

    SpecialDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return this.date;
    }

    public static boolean isContain(int date) {
        for(SpecialDate tempDate : values()) {
            if(tempDate.getDate() == date) {
                return true;
            }
        }
        return false;
    }
}
