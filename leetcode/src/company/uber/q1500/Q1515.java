package company.uber.q1500;

public class Q1515 {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    double error = 0.000001;

    public double getMinDistSum(int[][] positions) {
        double x = 0, y = 0;
        double steps = 50;
        double res = cal(x, y, positions);
        while (steps >= error) {
            boolean found = false;
            for (int[] dir : dirs) {
                double nextX = x + dir[0] * steps, nextY = y + dir[1] * steps;
                double dist = cal(nextX, nextY, positions);
                if (dist < res) {
                    res = dist;
                    x = nextX;
                    y = nextY;
                    found = true;
                    break;
                }
            }
            if (!found) steps /= 2;
        }
        return res;
    }

    private double cal(double x, double y, int[][] positions) {
        double res = 0;
        for (int[] p : positions) {
            res += Math.sqrt((p[0] - x) * (p[0] - x) + (p[1] - y) * (p[1] - y));
        }
        return res;
    }
}
