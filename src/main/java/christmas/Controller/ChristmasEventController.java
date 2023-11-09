package christmas.Controller;

import christmas.Model.*;
import christmas.View.OutputView;
import christmas.View.InputView;

public class ChristmasEventController {
    private final OrderResultList orderList = new OrderResultList();
    public void run () {
        inputDate();
        inputMenus();

    }

    private void inputDate () {
        OutputView.printGreeting();
        while(true) {
            try {
                int date = ValidationInput.isInteger(InputView.printInputDate(),"date");
                ValidationInput.isInvalidDate(date);
                orderList.updateOrderDate(date);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printContent(e.getMessage());
            }
        }
    }

    private void inputMenus () {
        while(true) {
            try {
                String[] splitedMenus = BusinessLogics.splitString(InputView.printInputMenus());
                for(int i = 0; i < splitedMenus.length; i++) {
                    String[] splitedNamePrice = BusinessLogics.splitMiddleBar(splitedMenus[i]);

                    ValidationInput.isInvalidMenuInput(splitedNamePrice);
                    String menu = splitedNamePrice[0];
                    int orderNumber = ValidationInput.isInteger(splitedNamePrice[1],"menu");

                    ValidationInput.isInvalidMenu(menu);
                    ValidationInput.isInvalidRange(orderNumber);

                    EachPriceList price = EachPriceList.valueOf(menu);
                    orderList.updateBeforeSalePrice(false, price.getPrice());
                    orderList.updateOrdersNumber(false,orderNumber);
                }
                ValidationInput.isInvalidRange(orderList.getOrdersNumber());
            } catch (IllegalArgumentException e) {
                orderList.updateOrdersNumber(true,0);
                orderList.updateBeforeSalePrice(true,0);
                OutputView.printContent(e.getMessage());
            }
        }
    }


}
