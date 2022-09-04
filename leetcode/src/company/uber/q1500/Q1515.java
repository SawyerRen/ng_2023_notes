package company.uber.q1500;

import java.util.LinkedList;
import java.util.Queue;

public class Q1515 {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    double error = 0.0000001;

    public double getMinDistSum(int[][] positions) {
        double i = 0, j = 0;
        double res = calDist(i, j, positions);
        double step = 50;
        while (step > error) {
            boolean found = false;
            for (int[] dir : dirs) {
                double x = i + dir[0] * step, y = j + dir[1] * step;
                double curDist = calDist(x, y, positions);
                if (curDist < res) {
                    res = curDist;
                    i = x;
                    j = y;
                    found = true;
                    break;
                }
            }
            step = !found ? step / 2 : step;
        }
        return res;
    }

    private double calDist(double i, double j, int[][] positions) {
        double dist = 0;
        for (int[] position : positions) {
            dist += Math.sqrt((position[0] - i) * (position[0] - i) + (position[1] - j) * (position[1] - j));
        }
        return dist;
    }
}
