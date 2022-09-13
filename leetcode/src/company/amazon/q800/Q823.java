package company.amazon.q800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q823 {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        map.put(arr[0], 1L);
        for (int i = 1; i < arr.length; i++) {
            long count = 1;
            for (Integer n : map.keySet()) {
                if (arr[i] % n == 0 && map.containsKey(arr[i] / n)) {
                    count += map.get(n) * map.get(arr[i] / n);
                }
            }
            map.put(arr[i], count);
        }
        long res = 0;
        for (long value : map.values()) {
            res = (res + value) % 1000000007;
        }
        return (int) res;
    }
}
