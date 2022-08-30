package company.bloomberg.q1300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] A = Arrays.copyOf(arr, arr.length);
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.putIfAbsent(num, map.size() + 1);
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
