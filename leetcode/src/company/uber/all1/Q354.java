package company.uber.all1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] arr = new int[envelopes.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = envelopes[i][1];
        }
        return helper(arr);
    }

    private int helper(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) < i) {
                list.add(i);
            } else {
                int index = search(list, i);
                list.set(index, i);
            }
        }
        return list.size();
    }

    private int search(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
