package company.uber.q1300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1359 {
    public int countOrders(int n) {
        List<String> pickup = new ArrayList<>();
        List<String> delivery = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            pickup.add("P" + i);
            delivery.add("D" + i);
        }
        List<List<String>> res = new ArrayList<>();
        helper(pickup, delivery, res, new ArrayList<String>(), new boolean[n], new boolean[n]);
        return res.size();
    }

    private void helper(List<String> pickup, List<String> delivery, List<List<String>> res, ArrayList<String> list, boolean[] picked, boolean[] delivered) {
        if (list.size() == pickup.size() * 2) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < pickup.size(); i++) {
            if (!picked[i]) {
                list.add(pickup.get(i));
                picked[i] = true;
                helper(pickup, delivery, res, list, picked, delivered);
                list.remove(list.size() - 1);
                picked[i] = false;
            }
        }
        for (int i = 0; i < delivery.size(); i++) {
            if (picked[i] && !delivered[i]) {
                list.add(delivery.get(i));
                delivered[i] = true;
                helper(pickup, delivery, res, list, picked, delivered);
                list.remove(list.size() - 1);
                delivered[i] = false;
            }
        }
    }
}
