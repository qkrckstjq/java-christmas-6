package christmas.View;

public class OutputView {
    public static void printMoney (String money) {
        System.out.println(money+"원");
    }

    public static void printContent (String content) {
        System.out.println(content);
    }

    public static void printOrders (String orders, String money) {
        System.out.println(orders+" "+money+"개");
    }

    public static void printSale (String saleName, String money) {
        System.out.println(saleName+": "+money+"원");
    }
}
