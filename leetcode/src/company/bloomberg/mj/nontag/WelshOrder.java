package company.bloomberg.mj.nontag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WelshOrder {
    String[] arr = {"a", "b", "c", "ch", "d", "dd", "e", "f", "ff", "g", "ng", "h", "i", "j", "l", "ll", "m", "n", "o", "p", "ph", "r", "rh", "s", "t", "th", "u", "w", "y"};

    void solution(List<String> input) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        input.sort((a, b) -> {
            List<Integer> order1 = helper(a, map);
            List<Integer> order2 = helper(b, map);
            for (int i = 0; i < Math.min(order1.size(), order2.size()); i++) {
                int o1 = order1.get(i);
                int o2 = order2.get(i);
                if (o1 != o2) return o1 - o2;
            }
            return order1.size() - order2.size();
        });
    }

    private List<Integer> helper(String a, Map<String, Integer> map) {
        char[] chars = a.toCharArray();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < chars.length - 1) {
            if (map.containsKey("" + chars[i] + chars[i + 1])) {
                list.add(map.get("" + chars[i] + chars[i + 1]));
                i += 2;
            } else {
                list.add(map.get("" + chars[i]));
                i++;
            }
        }
        if (i < chars.length) list.add(map.get("" + chars[i]));
        return list;
    }
}
