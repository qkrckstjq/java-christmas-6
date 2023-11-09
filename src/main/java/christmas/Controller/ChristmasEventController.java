package christmas.Controller;

import christmas.EnumPackage.EachPriceList;
import christmas.Model.*;
import christmas.View.OutputView;
import christmas.View.InputView;

public class ChristmasEventController {
    private final OrderResultList orderList = new OrderResultList();
    public void run () {
        inputDate();
        inputMenus();

        OutputView.printPreviewMessage(orderList.getOrderDate());

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
                orderList.initMenu();
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
                    orderList.updateMenu(menu,orderNumber);
                    orderList.updateOrderDetail(menu, orderNumber);
                }
                ValidationInput.isInvalidRange(orderList.getOrdersNumber());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printContent(e.getMessage());
            }
        }
    }

    private void printOrderList () {

    }


}
