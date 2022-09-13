package company.amazon.q0;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0, left = 0, right = 0;
        int count = t.length(), minLen = s.length() + 1;
        while (j < s.length()) {
            char rc = s.charAt(j);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) >= 0) count--;
            }
            while (count == 0) {
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    left = i;
                    right = j + 1;
                }
                char lc = s.charAt(i);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) >= 1) count++;
                }
                i++;
            }
            j++;
        }
        return s.substring(left, right);
    }
}
