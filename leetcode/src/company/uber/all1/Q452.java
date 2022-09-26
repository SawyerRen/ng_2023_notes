package company.uber.all1;

import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int end = points[0][1];
        int count = 1;
        for (int[] point : points) {
            if (point[0] > end) {
                end = point[1];
                count++;
            }
        }
        return count;
    }
}
