package christmas.Controller;

import christmas.EnumPackage.EachPriceList;
import christmas.EnumPackage.EventBadgeList;
import christmas.EnumPackage.PrintContentTitleList;
import christmas.Model.*;
import christmas.View.OutputView;
import christmas.View.InputView;
import org.mockito.internal.matchers.Or;

import java.io.PipedReader;
import java.util.HashMap;

public class ChristmasEventController {
    private final OrderResultList orderList = new OrderResultList();
    private final BusinessLogics BusinessLogics = new BusinessLogics();
    public void run () {
        inputDate();
        inputMenus();
        updateSaleDetail();

        OutputView.printPreviewMessage(orderList.getOrderDate());
        printOrderList();
        printBeforeSalePrice();
        printPresetMenu();
        printSaleDetails();
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
                    orderList.updateBeforeSalePrice(price.getPrice()*orderNumber);
                    orderList.updateOrdersNumber(orderNumber);
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

    private void updateSaleDetail () {
        orderList.updateChristmasSale();
        orderList.updateWeekSale();
        orderList.updateSpecialDateSale();
        orderList.updatePresentSale();
    }

    private void printOrderList () {
        OutputView.printContent(PrintContentTitleList.ORDER_MENU.getMessage());
        HashMap<String, Integer> temp = orderList.getOrderDetail();
        for(String key : temp.keySet()) {
            OutputView.printOrders(key, temp.get(key));
        }
        OutputView.printLineChange();
    }

    private void printBeforeSalePrice () {
        OutputView.printContent(PrintContentTitleList.BEFORE_SALE.getMessage());
        OutputView.printMoney(BusinessLogics.decimalFormatting(orderList.getBeforeSalePrice()));
        OutputView.printLineChange();
    }

    private void printPresetMenu () {
        OutputView.printContent(PrintContentTitleList.PRESENTATION_MENU.getMessage());
        if(orderList.isPresentSale()) {
            OutputView.printOrders("샴페인",1);
        }
        OutputView.printLineChange();
    }

    private void printSaleDetails () {
        OutputView.printContent(PrintContentTitleList.BENEFIT.getMessage());
        HashMap<String, Integer> temp = orderList.getSaleDetail();
        for(String key : temp.keySet()) {
            OutputView.printSale(key, BusinessLogics.decimalFormatting(temp.get(key)));
        }
        OutputView.printLineChange();
    }

    private void printTotalSalePrice () {
        OutputView.printContent(PrintContentTitleList.TOTAL_BENEFIT.getMessage());
        OutputView.printMoney(BusinessLogics.decimalFormatting(orderList.getTotalSalePrice()));
        OutputView.printLineChange();
    }

    private void printAfterSalePrice () {
        OutputView.printContent(PrintContentTitleList.AFTER_SALE.getMessage());
        OutputView.printMoney(BusinessLogics.decimalFormatting(orderList.getAfterSalePrice()));
        OutputView.printLineChange();
    }

    private void printEventBadge () {
        OutputView.printContent(PrintContentTitleList.EVENT_BADGE.getMessage());
        OutputView.printContent(EventBadgeList.getBadge(orderList.getTotalSalePrice()));
    }
}
