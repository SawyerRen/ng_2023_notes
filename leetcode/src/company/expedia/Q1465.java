package company.expedia;

import java.util.Arrays;

public class Q1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = horizontalCuts[0];
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            maxH = Math.max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        long maxW = verticalCuts[0];
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            maxW = Math.max(maxW, verticalCuts[i + 1] - verticalCuts[i]);
        }
        maxW = Math.max(maxW, w - verticalCuts[verticalCuts.length - 1]);
        return (int) ((int) maxH * maxW % 1000000007);
    }
}
