package company.uber.goodluck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalUnion {
    List<int[]> solution(int[][] list1, int[][] list2) {
        int i = 0, j = 0;
        int start = 0, end = 0;
        if (list1[i][0] < list2[j][0]) {
            start = list1[i][0];
            end = list1[i][1];
            i++;
        } else {
            start = list2[j][0];
            end = list2[j][1];
            j++;
        }
        List<int[]> res = new ArrayList<>();
        while (i < list1.length || j < list2.length) {
            if (j == list2.length || (i < list1.length && list1[i][0] < list2[j][0])) {
                if (end < list1[i][0]) {
                    res.add(new int[]{start, end});
                    start = list1[i][0];
                    end = list1[i][1];
                } else {
                    end = Math.max(end, list1[i][1]);
                }
                i++;
            } else if (i == list1.length || (j < list2.length && list2[j][0] <= list1[i][0])) {
                if (end < list2[i][0]) {
                    res.add(new int[]{start, end});
                    start = list2[i][0];
                    end = list2[i][1];
                } else {
                    end = Math.max(end, list2[j][1]);
                }
                j++;
            }
        }
        res.add(new int[]{start, end});
        return res;
    }
}
