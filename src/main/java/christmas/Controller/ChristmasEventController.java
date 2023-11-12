package christmas.Controller;

import christmas.EnumPackage.EachPriceList;
import christmas.EnumPackage.EventBadgeList;
import christmas.EnumPackage.PrintContentTitleList;
import christmas.Model.*;
import christmas.View.OutputView;
import christmas.View.InputView;
import java.util.HashMap;

public class ChristmasEventController {
    private OrderResultList orderList = new OrderResultList();
    private final BusinessLogics BusinessLogics = new BusinessLogics();
    public void run () {
        inputDate();
        inputMenu();
        updateSaleDetail();
        updateCalculateSale();
        OutputView.printPreviewMessage(orderList.getOrderDate());
        printOrderList();
        printBeforeSalePrice();
        printPresetMenu();
        printSaleDetails();
        printTotalSalePrice();
        printAfterSalePrice();
        printEventBadge();
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

    private void inputMenu () {
        while(true) {
            try {
                orderList.initOrderMenu();
                inputMenuValidate(orderList);
                break;
            } catch (IllegalArgumentException e) {
                orderList = new OrderResultList();
                OutputView.printContent(e.getMessage());
            }
        }
    }
    private void inputMenuValidate (OrderResultList orderList) {
        String[] splitedMenus = BusinessLogics.splitString(InputView.printInputMenus());
        for(String menuString : splitedMenus) {
            String[] splitedNamePrice = BusinessLogics.splitMiddleBar(menuString);
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
        ValidationInput.isOrderable(orderList.isOrderable());
        ValidationInput.isInvalidRange(orderList.getOrdersNumber());
    }

    private void updateSaleDetail () {
        orderList.updateChristmasSale();
        orderList.updateWeekSale();
        orderList.updateSpecialDateSale();
        orderList.updatePresentSale();
    }

    private void updateCalculateSale () {
        orderList.calculateAfterSalePrice();
    }

    private void printOrderList () {
        OutputView.printContent(PrintContentTitleList.ORDER_MENU.getMessage());
        if(orderList.getOrderDetail().isEmpty()) {
            OutputView.printNone();
        } else {
            for(String key : orderList.getOrderDetail().keySet()) {
                OutputView.printOrders(key, orderList.getOrderDetail().get(key));
            }
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
        } else {
            OutputView.printNone();
        }
        OutputView.printLineChange();
    }

    private void printSaleDetails () {
        OutputView.printContent(PrintContentTitleList.BENEFIT.getMessage());
        if(orderList.getSaleDetail().isEmpty()) {
            OutputView.printNone();
        } else {
            for(String key : orderList.getSaleDetail().keySet()) {
                OutputView.printSale(key, BusinessLogics.decimalFormatting(orderList.getSaleDetail().get(key)));
            }
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
        OutputView.printContent(EventBadgeList.getBadge(orderList.getTotalSalePrice()*-1));
    }
}
