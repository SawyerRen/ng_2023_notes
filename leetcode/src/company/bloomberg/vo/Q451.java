package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List[] lists = new List[s.length() + 1];
        for (Character c : map.keySet()) {
            Integer count = map.get(c);
            if (lists[count] == null) lists[count] = new ArrayList<Character>();
            lists[count].add(c);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (lists[i] != null) {
                List<Character> list = lists[i];
                for (Character c : list) {
                    for (int j = 0; j < i; j++) {
                        builder.append(c);
                    }
                }
            }
        }
        return builder.toString();
    }
}
