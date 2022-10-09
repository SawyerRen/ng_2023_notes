package company.bloomberg.r2;

import java.util.*;

public class Q218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        heights.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(0);
        int pre = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.add(-height[1]);
            } else {
                pq.remove(height[1]);
            }
            Integer poll = pq.peek();
            if (poll != pre) {
                res.add(Arrays.asList(height[0], poll));
                pre = poll;
            }
        }
        return res;
    }
}
