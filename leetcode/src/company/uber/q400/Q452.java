package company.uber.q400;

import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            if (end >= point[0]) continue;
            count++;
            end = point[1];
        }
        return count;
    }
}
