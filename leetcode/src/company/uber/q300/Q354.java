package company.uber.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return lis(heights);
    }

    private int lis(int[] heights) {
        List<Integer> list = new ArrayList<>();
        for (int height : heights) {
            if (list.isEmpty() || height > list.get(list.size() - 1)) {
                list.add(height);
            } else {
                int index = binarySearch(list, height);
                list.set(index, height);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int height) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= height) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
