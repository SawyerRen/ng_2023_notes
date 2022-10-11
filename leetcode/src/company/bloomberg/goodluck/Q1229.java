package company.bloomberg.goodluck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) {
                return new ArrayList<>(Arrays.asList(start, start + duration));
            }
            if (slots1[i][1] == end) i++;
            if (slots2[j][1] == end) j++;
        }
        return new ArrayList<>();
    }
}
