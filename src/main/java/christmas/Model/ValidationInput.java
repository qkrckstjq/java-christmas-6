package christmas.Model;

import christmas.EnumPackage.EachPriceList;
import christmas.EnumPackage.ErrorsList;

public class ValidationInput {
    public static int isInteger (String num, String type) throws IllegalArgumentException {
        try {
            int date = Integer.parseInt(num);
            return date;
        } catch (IllegalArgumentException e) {
            if(type == "date") {
                throw new IllegalArgumentException(ErrorsList.INVALID_DATETYPE.getMessage());
            }
            throw new IllegalArgumentException(ErrorsList.INVALID_INPUTNUMBERTYPE.getMessage());
        }
    }

    public static void isInvalidDate (int number) throws IllegalArgumentException {
        if(number < 1 || number > 31) {
            throw new IllegalArgumentException(ErrorsList.INVALID_DATE.getMessage());
        }
    }

    public static void isInvalidMenuInput (String[] NamePriceArr) {
        if(NamePriceArr.length != 2) {
            throw new IllegalArgumentException(ErrorsList.INVALID_INPUTTYPE.getMessage());
        }
    }

    public static void isInvalidMenu (String menu) {
        try {
            EachPriceList list = EachPriceList.valueOf(menu);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorsList.INVALID_MENU.getMessage());
        }
    }

    public static void isInvalidRange (int number) {
        if(number < 0 || number > 20) {
            throw new IllegalArgumentException(ErrorsList.INVALID_NUMBER.getMessage());
        }
    }

    public static void isOrderable (boolean bool) {
        if(!bool) {
            throw new IllegalArgumentException(ErrorsList.INVALID_ORDER.getMessage());
        }
    }
}
