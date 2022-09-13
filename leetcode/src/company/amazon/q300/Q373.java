package company.amazon.q300;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            pq.add(new int[]{nums1[0], nums2[i], 0});
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] poll = pq.poll();
            res.add(Arrays.asList(poll[0], poll[1]));
            if (poll[2] < nums1.length - 1) {
                pq.add(new int[]{nums1[poll[2] + 1], poll[1], poll[2] + 1});
            }
        }
        return res;
    }
}
