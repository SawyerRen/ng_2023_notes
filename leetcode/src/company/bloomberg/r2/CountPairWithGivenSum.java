package company.bloomberg.r2;

import java.util.HashMap;
import java.util.Map;

public class CountPairWithGivenSum {
    int solution(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            res += map.getOrDefault(target - num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
