package company.bloomberg.vo;

import java.util.HashMap;
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
        int half = arr.length / 2;
        int res = 0;
        for (int i = arr.length; i >= 0; i--) {
            while (count[i] > 0) {
                half -= i;
                res++;
                count[i]--;
                if (half <= 0) return res;
            }
        }
        return -1;
    }
}
