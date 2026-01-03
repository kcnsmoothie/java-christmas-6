package christmas.service;

import static christmas.constant.ViewMessage.ORDER_MENU;

import christmas.constant.Menu;
import christmas.constant.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MenuService {
    public Map<Menu, Integer> calculateOrder(List<String> menuName, List<Integer> amount) {
        Map<Menu, Integer> order = new HashMap<>();
        for (Menu menu : Menu.values()) {
            order.put(menu, 0);
        }
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            for (int i = 0; i < menuName.size(); i++) {
                if (Objects.equals(menuName.get(i), entry.getKey().getName())) {
                    order.put(entry.getKey(), amount.get(i));
                }
            }
        }
        return order;
    }

    public int calculateBeforeDcTotal(Map<Menu, Integer> order) {
        int beforeDcTotal = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            beforeDcTotal += entry.getKey().getPrice() * entry.getValue();
        }
        return (int) beforeDcTotal;
    }

    public int calculateChristmasDc(int date) {
        int christmasDc = 0;
        if (date <= 25) {
            christmasDc += -900 - (100 * date);
        }
        return christmasDc;
    }

    public int calculateWeekOrWeekend(int date, Map<Menu, Integer> order) {
        int dayDc = 0;
        if(date % 7 == 1 || date % 7 == 2){
            for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
                if (entry.getValue() > 0 && entry.getKey().getType() == Type.MAIN) {
                    dayDc -= 2023;
                }
            }
        }
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            if (entry.getValue() > 0 && entry.getKey().getType() == Type.DESSERT) {
                dayDc -= 2023;
            }
        }
        return dayDc;
    }

    public int calculateSpecialDc(int date) {
        int specialDc = 0;
        int[] specialDay = {3, 10, 17, 24, 25, 31};
        for (int day : specialDay) {
            if (day == date) {
                specialDc -= 1000;
                break;
            }
        }
        return specialDc;
    }

    public int calculateGiftMenu(int beforeDcTotal) {
        int giftMenu = 0;
        if (beforeDcTotal >= 120000) {
            giftMenu = 1;
        }
        return giftMenu;
    }
}
