package company.uber.q1500;

import java.util.LinkedList;
import java.util.Queue;

public class Q1515 {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    double error = 0.0000001;

    public double getMinDistSum(int[][] positions) {
        double x = 0, y = 0;
        double res = calDist(positions, x, y);
        double steps = 50;
        while (steps > error) {
            boolean found = false;
            for (int[] dir : dirs) {
                double nx = x + dir[0] * steps, ny = y + dir[1] * steps;
                double dist = calDist(positions, nx, ny);
                if (dist < res) {
                    res = dist;
                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }
            steps = found ? steps : steps / 2;
        }
        return res;
    }

    private double calDist(int[][] positions, double x, double y) {
        double dist = 0;
        for (int[] p : positions) {
            dist += Math.sqrt((x - p[0]) * (x - p[0]) + (y - p[1]) * (y - p[1]));
        }
        return dist;
    }
}
