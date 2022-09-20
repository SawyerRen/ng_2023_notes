package company.expedia;

import java.util.HashMap;
import java.util.Map;

public class Q1010 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : time) {
            int mod = i % 60;
            int n = mod == 0 ? 0 : 60 - mod;
            res += map.getOrDefault(n, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }
}
