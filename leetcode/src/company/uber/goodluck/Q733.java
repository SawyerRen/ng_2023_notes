package company.uber.goodluck;

public class Q733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int m = image.length, n = image[0].length;
        helper(image, sr, sc, image[sr][sc], color, m, n);
        return image;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void helper(int[][] image, int i, int j, int oldColor, int color, int m, int n) {
        image[i][j] = color;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oldColor) continue;
            helper(image, x, y, oldColor, color, m, n);
        }
    }
}
