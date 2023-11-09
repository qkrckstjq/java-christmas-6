package christmas.View;

public class OutputView {

    public static void printGreeting () {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
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

    public static void printPreviewMessage (int number) {
        System.out.println("12월 "+number+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printNone () {
        System.out.println("없음");
    }

}
