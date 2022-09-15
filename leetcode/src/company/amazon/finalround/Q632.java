package company.amazon.finalround;

import java.util.List;
import java.util.PriorityQueue;

public class Q632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int max = 0, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[]{i, 0});
            max = Math.max(nums.get(i).get(0), max);
        }
        while (pq.size() == nums.size()) {
            int[] poll = pq.poll();
            int num = nums.get(poll[0]).get(poll[1]);
            if (end - start > max - num) {
                end = max;
                start = num;
            }
            if (poll[1] + 1 < nums.get(poll[0]).size()) {
                max = Math.max(max, nums.get(poll[0]).get(poll[1] + 1));
                pq.add(new int[]{poll[0], poll[1] + 1});
            }
        }
        return new int[]{start, end};
    }
}
