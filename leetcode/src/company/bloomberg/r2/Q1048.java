package company.bloomberg.r2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (String word : words) {
            int cur = 0;
            for (int i = 0; i < word.length(); i++) {
                String pre = word.substring(0, i) + word.substring(i + 1);
                cur = Math.max(cur, map.getOrDefault(pre, 0) + 1);
            }
            map.put(word, cur);
            res = Math.max(res, cur);
        }
        return res;
    }
}
