package christmas.Model;

public class ValidationInput {
    public static int isInteger (String num) throws IllegalArgumentException {
        try {
            int date = Integer.parseInt(num);
            return date;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInvalidDate (int num) throws IllegalArgumentException {
        if(num < 1 || num > 31) {
            throw new IllegalArgumentException();
        }
    }
}
