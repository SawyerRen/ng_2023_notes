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
        helper(res, new ArrayList<String>(), pickup, new boolean[n], delivery, new boolean[n]);
        return res.size();
    }

    private void helper(List<List<String>> res, ArrayList<String> list, List<String> pickup, boolean[] picked, List<String> delivery, boolean[] delivered) {
        if (list.size() == pickup.size() * 2) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < picked.length; i++) {
            if (picked[i]) continue;
            picked[i] = true;
            list.add(pickup.get(i));
            helper(res, list, pickup, picked, delivery, delivered);
            picked[i] = false;
            list.remove(list.size() - 1);
        }
        for (int i = 0; i < delivery.size(); i++) {
            if (delivered[i] || !picked[i]) continue;
            delivered[i] = true;
            list.add(delivery.get(i));
            helper(res, list, pickup, picked, delivery, delivered);
            delivered[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
