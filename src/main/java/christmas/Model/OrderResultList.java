package christmas.Model;

import christmas.EnumPackage.EachPriceList;
import christmas.EnumPackage.SaleVariable;
import christmas.EnumPackage.SpecialDate;
import com.sun.tools.javac.Main;
import java.util.Map;

import java.util.HashMap;

public class OrderResultList {
    private final int WEEKDAY_START = 3;
    private final int SPECIAL_SALE_PRICE = 1000;
    private final int WEEK_SALE_PRICE = 2023;
    private final int PRESENT_PRICE_CUTLINE = 120000;
    private int orderDate;
    private int ordersNumber = 0;
    private int beforeSalePrice = 0;
    private int afterSalePrice;
    private int totalSalePrice;

    private DataObject orderMenu = new DataObject();
    private HashMap<String, Integer> orderDetail = new HashMap<>();
    private HashMap<String, Integer> saleDetail = new HashMap<>();

    public void updateOrderDate (int num) {
        this.orderDate = num;
    }

    public int getOrderDate () {
        return orderDate;
    }

    public int getOrdersNumber () {
        return this.ordersNumber;
    }

    public HashMap<String, Integer> getOrderDetail () {
        return this.orderDetail;
    }

    public HashMap<String, Integer> getSaleDetail () {
        return this.saleDetail;
    }

    public int getBeforeSalePrice () {
        return this.beforeSalePrice;
    }

    public boolean isPresentSale () {
        if(beforeSalePrice >= PRESENT_PRICE_CUTLINE) {
            return true;
        }
        return false;
    }

    public int getTotalSalePrice () {
        return totalSalePrice;
    }

    public int getAfterSalePrice () {
        return afterSalePrice;
    }

    public void updateOrdersNumber (int number) {
        this.ordersNumber += number;
    }

    public void updateBeforeSalePrice (int number) {
        this.beforeSalePrice += number;
    }


    public void initMenu () {
        orderMenu.initMenu();
    }
    public void updateMenu (String menu, int number) {
        orderMenu.updateMenu(menu, number);
    }

    public void updateOrderDetail (String menu, int number) {
        if(!orderDetail.containsKey(menu)) {
            orderDetail.put(menu,number);
        } else {
            orderDetail.put(menu,orderDetail.get(menu)+number);
        }
    }

    public void updateChristmasSale () {
        if(orderDate >= 1 && orderDate <= 25) {
            int salePrice = 1000 + (orderDate-1)*100;
            saleDetail.put(SaleVariable.CHRISTMAS_SALE.getMessage(), salePrice*-1);
        }
    }

    public void updateWeekSale () {
        int lastDate = orderDate % 7;
        int dessertNumber = orderMenu.getDessertNumber();
        int MainNumber = orderMenu.getMainNumber();
        if((lastDate == 1 || lastDate == 2) && dessertNumber != 0) {
            saleDetail.put(SaleVariable.WEEKEND_SALE.getMessage(), WEEK_SALE_PRICE*dessertNumber*-1);
        } else if (MainNumber != 0) {
            saleDetail.put(SaleVariable.WEEKDAY_SALE.getMessage(), WEEK_SALE_PRICE*MainNumber*-1);
        }
    }

    public void updateSpecialDateSale () {
        if(SpecialDate.isContain(orderDate)) {
            saleDetail.put(SaleVariable.SPECIAL_SALE.getMessage(), SPECIAL_SALE_PRICE*-1);
        }
    }

    public void updatePresentSale () {
        if(beforeSalePrice >= PRESENT_PRICE_CUTLINE) {
            saleDetail.put(SaleVariable.PRESENT_SALE.getMessage(), EachPriceList.샴페인.getPrice()*-1);
        }
    }

    public void calculateAfterSalePrice () {
        this.afterSalePrice = beforeSalePrice;
        for(String key : saleDetail.keySet()) {
            afterSalePrice+=saleDetail.get(key);
            totalSalePrice+=saleDetail.get(key);
        }
    }


}
