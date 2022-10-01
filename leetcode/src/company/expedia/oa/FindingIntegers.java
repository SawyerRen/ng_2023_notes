package company.expedia.oa;

import java.util.PriorityQueue;

public class FindingIntegers {
    static int[] solution(int n, int k, int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) pq.poll();
            if (i - k + 1 >= 0) res[i - k + 1] = pq.peek();
        }
        return res;
    }
}
