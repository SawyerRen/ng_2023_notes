package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1636 {
    public int[] frequencySort(int[] nums) {
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
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (lists[i] != null) {
                List<Integer> list = lists[i];
                list.sort((a, b) -> b - a);
                for (Integer num : list) {
                    for (int j = 0; j < i; j++) {
                        res[index++] = num;
                    }
                }
            }
        }
        return res;
    }
}
