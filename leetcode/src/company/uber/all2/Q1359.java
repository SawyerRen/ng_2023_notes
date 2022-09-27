package company.uber.all2;

import java.util.ArrayList;
import java.util.List;

public class Q1359 {
    public int countOrders(int n) {
        String[] deliver = new String[n];
        String[] pickup = new String[n];
        for (int i = 0; i < n; i++) {
            deliver[i] = "D" + i;
            pickup[i] = "P" + i;
        }
        boolean[] picked = new boolean[n];
        boolean[] delivered = new boolean[n];
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<String>(), deliver, pickup, delivered, picked, n);
        return res.size();
    }

    private void helper(List<List<String>> res, List<String> list, String[] deliver, String[] pickup, boolean[] delivered, boolean[] picked, int n) {
        if (list.size() == n * 2) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (picked[i]) continue;
            picked[i] = true;
            list.add(pickup[i]);
            helper(res, list, deliver, pickup, delivered, picked, n);
            list.remove(list.size() - 1);
            picked[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (delivered[i] || !picked[i]) continue;
            delivered[i] = true;
            list.add(deliver[i]);
            helper(res, list, deliver, pickup, delivered, picked, n);
            list.remove(list.size() - 1);
            delivered[i] = false;
        }
    }
}
