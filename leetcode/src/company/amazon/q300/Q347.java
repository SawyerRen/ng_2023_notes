package company.amazon.q300;

import java.util.*;

public class Q347 {
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List[] lists = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            Integer count = map.get(num);
            if (lists[count] == null) lists[count] = new ArrayList<Integer>();
            lists[count].add(num);
        }
        int[] res = new int[k];
        for (int i = nums.length; i >= 0 && k > 0; i--) {
            if (lists[i] != null) {
                for (Object num : lists[i]) {
                    res[--k] = (int) num;
                }
            }
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            pq.add(new int[]{num, count});
            if (pq.size() > k) pq.poll();
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
