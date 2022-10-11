package company.bloomberg.mj.nontag2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q8 {
    String[] arr = {"a", "b", "c", "ch", "d", "dd", "e", "f", "ff", "g", "ng", "h", "i", "j", "l", "ll", "m", "n", "o", "p", "ph", "r", "rh", "s", "t", "th", "u", "w", "y"};

    void solution(List<String> input) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        input.sort((a, b) -> {
            List<Integer> orderA = helper(map, a);
            List<Integer> orderB = helper(map, b);
            for (int i = 0; i < Math.min(orderA.size(), orderB.size()); i++) {
                int n1 = orderA.get(i);
                int n2 = orderB.get(i);
                if (n1 != n2) return n1 - n2;
            }
            return orderA.size() - orderB.size();
        });
    }

    private List<Integer> helper(Map<String, Integer> map, String s) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            if (index < s.length() - 1 && map.containsKey(s.substring(index, index + 2))) {
                list.add(map.get(s.substring(index, index + 2)));
                index += 2;
            } else {
                list.add(map.get(s.substring(index, index + 1)));
                index++;
            }
        }
        return list;
    }
}
