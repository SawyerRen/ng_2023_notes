package company.bloomberg.goodluck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] count = new int[arr.length + 1];
        for (Integer value : map.values()) {
            count[value]++;
        }
        int res = 0;
        int half = arr.length / 2;
        for (int i = count.length - 1; i > 0; i--) {
            while (count[i] > 0) {
                if (half <= 0) return res;
                half -= i;
                count[i]--;
                res++;
            }
        }
        return res;
    }
}
