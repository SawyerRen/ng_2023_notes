package company.amazon.finalround;

import java.util.HashMap;
import java.util.Map;

public class Q1525 {
    public int numSplits(String s) {
        Map<Character, Integer> right = new HashMap<>();
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> left = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            right.put(c, right.get(c) - 1);
            if (right.get(c) == 0) right.remove(c);
            left.put(c, left.getOrDefault(c, 0) + 1);
            if (left.size() == right.size()) res++;
        }
        return res;
    }
}
