package company.amazon.q1800;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1834 {
    public int[] getOrder(int[][] tasks) {
        int[][] taskArr = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            taskArr[i][0] = i;
            taskArr[i][1] = tasks[i][0];
            taskArr[i][2] = tasks[i][1];
        }
        Arrays.sort(taskArr, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int time = 0, timeIndex = 0, index = 0;
        int[] res = new int[taskArr.length];
        while (index < tasks.length) {
            while (timeIndex < taskArr.length && taskArr[timeIndex][1] <= time) {
                pq.add(taskArr[timeIndex++]);
            }
            if (pq.isEmpty()) {
                time = taskArr[timeIndex][1];
                continue;
            }
            int[] poll = pq.poll();
            res[index++] = poll[0];
            time += poll[2];
        }
        return res;
    }
}
