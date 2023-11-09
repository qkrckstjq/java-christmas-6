package christmas.Model;

import christmas.EnumPackage.MenuItem;

import java.util.HashMap;
import java.util.Map;
public class DataObject {
    private String[] menuType = {"에피타이저","메인","디저트","음료"};
    private final HashMap<String, Integer> menu = new HashMap<>();

    public void initMenu () {
        for(int i = 0; i < menuType.length; i++) {
            menu.put(menuType[i],0);
        }
    }
    public void updateMenu (String name, int number) {
        MenuItem menuName = MenuItem.valueOf(name);
        menu.put(menuName.getCategory(), menu.get(menuName.getCategory())+number);
    }

    public boolean isOrderable () {
        for(String key : menu.keySet()) {
            if(key != "음료") {
                return true;
            }
        }
        return false;
    }

    public int getDessertNumber () {
        return menu.get("디저트");
    }

    public int getMainNumber () {
        return menu.get("메인");
    }
}
