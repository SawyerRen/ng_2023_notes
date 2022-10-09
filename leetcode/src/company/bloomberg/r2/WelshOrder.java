package company.bloomberg.r2;

import java.util.*;

public class WelshOrder {
    String[] arr = {"a", "b", "c", "ch", "d", "dd", "e", "f", "ff", "g", "ng", "h", "i", "j", "l", "ll", "m", "n", "o", "p", "ph", "r", "rh", "s", "t", "th", "u", "w", "y"};

    void solution(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr, (a, b) -> {
            List<Integer> order1 = helper(map, a);
            List<Integer> order2 = helper(map, b);
            for (int i = 0; i < Math.min(order1.size(), order2.size()); i++) {
                int index1 = order1.get(i);
                int index2 = order2.get(i);
                if (index1 != index2) return index1 - index2;
            }
            return order1.size() - order2.size();
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
