package company.expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (arr[i + 1] - arr[i] < minDiff) {
                minDiff = arr[i + 1] - arr[i];
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
