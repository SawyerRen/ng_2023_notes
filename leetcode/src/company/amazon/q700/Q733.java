package company.amazon.q700;

public class Q733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        helper(image, sr, sc, image.length, image[0].length, image[sr][sc], color);
        return image;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void helper(int[][] image, int i, int j, int m, int n, int oldColor, int color) {
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != oldColor) return;
        image[i][j] = color;
        for (int[] dir : dirs) {
            helper(image, i + dir[0], j + dir[1], m, n, oldColor, color);
        }
    }
}
