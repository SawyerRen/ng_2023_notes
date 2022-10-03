package company.uber.lastround;

public class Q1515 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    double error = 0.0000001;

    public double getMinDistSum(int[][] positions) {
        double i = 0, j = 0;
        double res = helper(positions, i, j);
        double step = 50;
        while (step > error) {
            boolean found = false;
            for (int[] dir : dirs) {
                double x = i + dir[0] * step, y = j + dir[1] * step;
                double dist = helper(positions, x, y);
                if (dist < res) {
                    res = dist;
                    i = x;
                    j = y;
                    found = true;
                    break;
                }
            }
            if (!found) step /= 2;
        }
        return res;
    }

    private double helper(int[][] positions, double i, double j) {
        double res = 0;
        for (int[] p : positions) {
            res += Math.sqrt((p[0] - i) * (p[0] - i) + (p[1] - j) * (p[1] - j));
        }
        return res;
    }
}
