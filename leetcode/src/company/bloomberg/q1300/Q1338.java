package company.bloomberg.q1300;

import java.util.HashMap;
import java.util.Map;

public class Q1338 {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int half = n / 2, remove = 0;
        int[] count = new int[n + 1];
        for (Integer val : map.keySet()) {
            count[map.get(val)]++;
        }
        for (int i = n; i > 0 && half > 0; i--) {
            while (count[i] > 0) {
                half -= i;
                remove++;
                if (half <= 0) break;
                count[i]--;
            }
        }
        return remove;
    }
}
