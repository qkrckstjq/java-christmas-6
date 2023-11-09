package christmas.Model;

import java.text.DecimalFormat;

public class BusinessLogics {
    DecimalFormat decimalFormat = new DecimalFormat("#,###");
    public String[] splitString (String input) {
        String terminatedWhiteSpace = input.trim();
        String[] splitedStr = terminatedWhiteSpace.split(",");
        return splitedStr;
    }

    public String[] splitMiddleBar (String str) {
        String[] splitedStr = str.split("-");
        return splitedStr;
    }

    public String decimalFormatting (int number) {
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
    }

}
