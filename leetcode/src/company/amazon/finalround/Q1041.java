package company.amazon.finalround;

public class Q1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int i = 0, j = 0;
        int d = 1;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                i += dirs[d][0];
                j += dirs[d][1];
            } else if (c == 'L') {
                d = (4 + d - 1) % 4;
            } else {
                d = (d + 1) % 4;
            }
        }
        if (i == 0 && j == 0) return true;
        return d != 1;
    }
}
