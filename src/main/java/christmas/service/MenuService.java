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
}
