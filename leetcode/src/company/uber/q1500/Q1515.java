package company.uber.q1500;

import java.util.ArrayList;
import java.util.List;

public class Q1515 {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    double error = 0.0000001;

    public double getMinDistSum(int[][] positions) {
        double x = 0, y = 0;
        double steps = 50;
        double res = calDist(x, y, positions);
        while (steps > error) {
            boolean found = false;
            for (int[] dir : dirs) {
                double nx = x + dir[0] * steps, ny = y + dir[1] * steps;
                double cur = calDist(nx, ny, positions);
                if (cur < res) {
                    res = cur;
                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }
            steps /= found ? 1 : 2;
        }
        return res;
    }

    private double calDist(double x, double y, int[][] positions) {
        double dist = 0;
        for (int[] p : positions) {
            dist += Math.sqrt((x - p[0]) * (x - p[0]) + (y - p[1]) * (y - p[1]));
        }
        return dist;
    }
}
