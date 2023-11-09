package christmas.Model;

public class BusinessLogics {
    public static String[] splitString (String input) {
        String terminatedWhiteSpace = input.trim();
        String[] splitedStr = terminatedWhiteSpace.split(",");
        return splitedStr;
    }

    public static String[] splitMiddleBar (String str) {
        String[] splitedStr = str.split("-");
        return splitedStr;
    }

}
