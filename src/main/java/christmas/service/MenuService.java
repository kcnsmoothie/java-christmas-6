package christmas.service;

import christmas.constant.Menu;
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
            christmasDc += 900 + (100 * date);
        }
        return christmasDc;
    }

    public void calculateWeekdayDc(int date) {
        int weekdayDc = 0;
        if(date)
    }
}
