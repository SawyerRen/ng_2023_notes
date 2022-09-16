package company.amazon.finalround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[1] - b[0]);
        for (int i = 0; i < nums1.length; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            int[] poll = pq.poll();
            res.add(Arrays.asList(poll[0], poll[1]));
            int index = poll[2];
            if (index + 1 < nums2.length) {
                pq.add(new int[]{poll[0], nums2[index + 1], index + 1});
            }
        }
        return res;
    }
}
