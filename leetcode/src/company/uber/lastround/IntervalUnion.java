package company.uber.lastround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalUnion {
    List<int[]> solution(int[][] list1, int[][] list2) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int[] pre;
        Arrays.sort(list1, (a, b) -> a[0] - b[0]);
        Arrays.sort(list2, (a, b) -> a[0] - b[0]);
        if (list1[0][0] < list2[0][0]) {
            pre = list1[0];
            i++;
        } else {
            pre = list2[0];
            j++;
        }
        while (i < list1.length || j < list2.length) {
            if (j == list2.length || i < list1.length && list1[i][0] < list2[j][0]) {
                if (list1[i][0] > pre[1]) {
                    res.add(pre);
                    pre = list1[i];
                } else {
                    pre[1] = Math.max(pre[1], list1[i][1]);
                }
                i++;
            } else if (i == list1.length || j < list2.length && list2[j][0] < list1[i][0]) {
                if (list2[j][0] > pre[1]) {
                    res.add(pre);
                    pre = list2[j];
                } else {
                    pre[1] = Math.max(pre[1], list2[j][1]);
                }
                j++;
            }
        }
        res.add(pre);
        return res;
    }
}
