package company.uber.all1;

public class Q11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int n = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, n);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
