package company.bloomberg.r2;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationTo1 {
    Map<Integer, Integer> map = new HashMap<>();

    int solution(int num) {
        if (num == 1) return 0;
        if (map.containsKey(num)) return map.get(num);
        int res = Integer.MAX_VALUE;
        res = Math.min(res, solution(num * 2));
        res = Math.min(res, solution(num / 3));
        map.put(num, res);
        return res;
    }


}
