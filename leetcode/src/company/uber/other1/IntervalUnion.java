package company.uber.other1;

import java.util.ArrayList;
import java.util.List;

public class IntervalUnion {
    public List<int[]> solution(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int[] pre;
        if (firstList[i][0] < secondList[j][0]) {
            pre = firstList[i++];
        } else {
            pre = secondList[j++];
        }
        while (i < firstList.length || j < secondList.length) {
            if (j == secondList.length || (i < firstList.length && firstList[i][0] < secondList[j][0])) {
                if (firstList[i][0] > pre[1]) {
                    res.add(pre);
                    pre = firstList[i];
                } else {
                    pre[1] = Math.max(pre[1], firstList[i][1]);
                }
                i++;
            } else if (i == firstList.length || secondList[j][0] < firstList[i][0]) {
                if (secondList[j][0] > pre[1]) {
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
