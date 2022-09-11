package company.amazon.q600;

import java.util.List;
import java.util.PriorityQueue;

public class Q632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int start = 0, end = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (pq.size() == nums.size()) {
            int[] poll = pq.poll();
            int num = nums.get(poll[0]).get(poll[1]);
            if (max - num < end - start) {
                start = num;
                end = max;
            }
            if (poll[1] + 1 < nums.get(poll[0]).size()) {
                pq.add(new int[]{poll[0], poll[1] + 1});
                max = Math.max(max, nums.get(poll[0]).get(poll[1] + 1));
            }
        }
        return new int[]{start, end};
    }
}
