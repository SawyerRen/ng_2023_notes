package company.amazon.finalround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i : nums1) {
            pq.add(new int[]{i, nums2[0], 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; !pq.isEmpty() && i < k; i++) {
            int[] poll = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(poll[0], poll[1])));
            if (poll[2] + 1 < nums2.length) {
                pq.add(new int[]{poll[0], nums2[poll[2] + 1], poll[2] + 1});
            }
        }
        return res;
    }
}
