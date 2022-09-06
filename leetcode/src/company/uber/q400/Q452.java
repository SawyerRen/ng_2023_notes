package company.uber.q400;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int end = points[0][1], res = 1;
        for (int[] point : points) {
            if (point[0] > end) {
                res++;
                end = point[1];
            }
        }
        return res;
    }
}
