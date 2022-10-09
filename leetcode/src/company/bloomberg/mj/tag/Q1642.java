package company.bloomberg.mj.tag;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i + 1] > heights[i]) {
                int diff = heights[i + 1] - heights[i];
                pq.add(diff);
                bricks -= diff;
                if (bricks < 0) {
                    if (ladders == 0) return i;
                    ladders--;
                    bricks += pq.poll();
                }
            }
        }
        return heights.length - 1;
    }
}
