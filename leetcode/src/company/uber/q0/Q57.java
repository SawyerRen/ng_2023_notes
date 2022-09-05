package company.uber.q0;

import java.util.ArrayList;
import java.util.List;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index = 0;
        int start = newInterval[0], end = newInterval[1];
        while (index < intervals.length && intervals[index][1] < start) {
            list.add(intervals[index++]);
        }
        while (index < intervals.length && intervals[index][0] <= end) {
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
            index++;
        }
        list.add(new int[]{start, end});
        while (index < intervals.length) list.add(intervals[index++]);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
