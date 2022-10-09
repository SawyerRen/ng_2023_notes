package company.bloomberg.mj.nontag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintCoinChange {
    static void solution(int amount, int[] coins) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        for (int i = 1; i <= amount; i++) {
            List<Integer> list = null;
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && map.containsKey(i - coin)) {
                    List<Integer> pre = map.get(i - coin);
                    if (pre.size() < min) {
                        min = pre.size();
                        list = new ArrayList<>(pre);
                        list.add(coin);
                    }
                }
            }
            map.put(i, list);
        }
        System.out.println(map.get(amount));
    }

    public static void main(String[] args) {
        solution(11, new int[]{1, 2, 5});
    }
}
