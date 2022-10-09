package company.bloomberg.r2;

import java.util.HashMap;
import java.util.Map;

public class Q1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int size = arr.length / 2;
        int[] count = new int[arr.length + 1];
        for (Integer value : map.values()) {
            count[value]++;
        }
        int res = 0;
        for (int i = arr.length; i >= 0; i--) {
            while (count[i] > 0) {
                res++;
                size -= i;
                count[i]--;
                if (size <= 0) return res;
            }
        }
        return -1;
    }
}
