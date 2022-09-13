package company.amazon.q1000;

public class Q1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int i = 0, j = 0, d = 1;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                d = (d - 1 + 4) % 4;
            } else if (c == 'R') {
                d = (d + 1) % 4;
            } else {
                i += dirs[d][0];
                j += dirs[d][1];
            }
        }
        if (i == 0 && j == 0) return true;
        return d != 1;
    }
}
