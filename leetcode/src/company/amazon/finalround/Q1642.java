package company.amazon.finalround;

import java.util.PriorityQueue;

public class Q1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i + 1] > heights[i]) {
                int diff = heights[i + 1] - heights[i];
                pq.add(diff);
                if (pq.size() > ladders) {
                    sum += pq.poll();
                }
                if (sum > bricks) return i;
            }
        }
        return heights.length - 1;
    }
}
