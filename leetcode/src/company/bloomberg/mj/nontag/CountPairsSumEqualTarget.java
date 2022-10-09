package company.bloomberg.mj.nontag;

import java.util.HashMap;
import java.util.Map;

public class CountPairsSumEqualTarget {
    static int solution(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            res += map.getOrDefault(target - num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3};
        System.out.println(solution(arr, 4));
    }
}
