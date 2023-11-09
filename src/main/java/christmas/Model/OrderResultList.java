package christmas.Model;

import christmas.Model.DataObject;

import java.util.HashMap;

public class OrderResultList {
    private int orderDate;
    private int ordersNumber = 0;
    private int beforeSalePrice = 0;

    private DataObject orderMenu = new DataObject();

    public void updateOrderDate (int num) {
        this.orderDate = num;
    }

    public void updateOrdersNumber (boolean isInit, int number) {
        if(isInit) {
            this.ordersNumber = number;
        }
        this.ordersNumber += number;
    }

    public int getOrdersNumber () {
        return this.ordersNumber;
    }

    public void updateBeforeSalePrice (boolean isInit, int number) {
        if(isInit) {
            this.beforeSalePrice = number;
        }
        this.beforeSalePrice += number;
    }

    public int getBeforeSalePrice () {
        return this.beforeSalePrice;
    }

    public void initMenu () {
        orderMenu.initMenu();
    }
    public void updateMenu (String menu, int number) {
        orderMenu.updateMenu(menu, number);
    }

    public void printOrderList () {
        orderMenu.print();
    }

}
