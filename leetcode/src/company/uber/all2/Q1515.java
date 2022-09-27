package company.uber.all2;

public class Q1515 {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    double error = 0.00000001;

    public double getMinDistSum(int[][] positions) {
        double i = 0, j = 0;
        double res = cal(positions, i, j);
        double steps = 50;
        while (steps >= error) {
            boolean found = false;
            for (int[] dir : dirs) {
                double x = i + dir[0] * steps, y = j + dir[1] * steps;
                double dist = cal(positions, x, y);
                if (dist < res) {
                    found = true;
                    res = dist;
                    i = x;
                    j = y;
                    break;
                }
            }
            if (!found) steps /= 2;
        }
        return res;
    }

    private double cal(int[][] positions, double i, double j) {
        double res = 0;
        for (int[] p : positions) {
            res += Math.sqrt((p[0] - i) * (p[0] - i) + (p[1] - j) * (p[1] - j));
        }
        return res;
    }
}
