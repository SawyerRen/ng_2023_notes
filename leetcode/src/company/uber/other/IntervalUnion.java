package company.uber.other;

import java.util.ArrayList;
import java.util.List;

public class IntervalUnion {
    public List<int[]> solution(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int[] pre = null;
        if (firstList[i][0] < secondList[j][0]) {
            pre = firstList[i];
            i++;
        } else {
            pre = secondList[j];
            j++;
        }
        while (i < firstList.length || j < secondList.length) {
            if (j == secondList.length || (i < firstList.length && firstList[i][0] < secondList[j][0])) {
                if (pre[1] < firstList[i][0]) {
                    res.add(pre);
                    pre = firstList[i];
                } else {
                    pre[1] = Math.max(pre[1], firstList[i][1]);
                }
                i++;
            } else if (i == firstList.length || (j < secondList.length && firstList[i][0] > secondList[j][0])) {
                if (pre[1] < secondList[j][0]) {
                    res.add(pre);
                    pre = secondList[j];
                } else {
                    pre[1] = Math.max(pre[1], secondList[j][1]);
                }
                j++;
            }
        }
        res.add(pre);
        return res;
    }
}
