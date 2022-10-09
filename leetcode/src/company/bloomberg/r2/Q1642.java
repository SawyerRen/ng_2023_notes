package company.bloomberg.r2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                pq.add(diff);
                bricks -= diff;
                if (bricks < 0) {
                    if (ladders > 0) {
                        bricks += pq.poll();
                        ladders--;
                    } else {
                        return i;
                    }
                }
            }
        }
        return heights.length - 1;
    }
}
