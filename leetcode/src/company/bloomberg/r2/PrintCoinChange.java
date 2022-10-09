package company.bloomberg.r2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintCoinChange {
    void solution(int[] coins, int amount) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        for (int i = 1; i <= amount; i++) {
            List<Integer> list = null;
            int size = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && map.containsKey(i - coin)) {
                    if (size > map.get(i - coin).size()) {
                        size = map.get(i - coin).size();
                        list = new ArrayList<>(map.get(i - coin));
                        list.add(coin);
                    }
                }
            }
            if (list != null) map.put(i, list);
        }
        List<Integer> list = map.get(amount);
        System.out.println(list);
    }
}
