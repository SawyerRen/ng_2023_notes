package company.bloomberg.goodluck;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1048 {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int cur = 0;
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + word.substring(i + 1);
                cur = Math.max(cur, map.getOrDefault(sub, 0) + 1);
            }
            res = Math.max(res, cur);
            map.put(word, cur);
        }
        return res;
    }
}
