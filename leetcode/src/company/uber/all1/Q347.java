package company.uber.all1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List[] lists = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            Integer count = map.get(num);
            if (lists[count] == null) lists[count] = new ArrayList();
            lists[count].add(num);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0 && index < res.length; i--) {
            if (lists[i] != null) {
                List<Integer> list = lists[i];
                for (Integer integer : list) {
                    res[index++] = integer;
                    if (index == res.length) break;
                }
            }
        }
        return res;
    }
}
