package company.amazon.q600;

import java.util.List;
import java.util.PriorityQueue;

public class Q632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (pq.size() == nums.size()) {
            int[] poll = pq.poll();
            int i = poll[0], j = poll[1];
            if (end - start > max - nums.get(i).get(j)) {
                start = nums.get(i).get(j);
                end = max;
            }
            if (j + 1 < nums.get(i).size()) {
                pq.add(new int[]{i, j + 1});
                max = Math.max(max, nums.get(i).get(j + 1));
            }
        }
        return new int[]{start, end};
    }
}
