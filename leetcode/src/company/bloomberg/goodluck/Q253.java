package company.bloomberg.goodluck;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        //Sort time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //minHeap
        // int room = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);//要先加一个进去
        for(int i = 1; i < intervals.length; i++){  //这里的index 就从 1开始啦
                 
            if(intervals[i][0] >= minHeap.peek()){//只记录end 的时间就可以判断有没有结束了
                //有结束的就poll出来
                minHeap.poll();                
            }
            minHeap.add(intervals[i][1]);
            // room = Math.max(room, minHeap.size());这里是替换不会减少房间
        }

        return minHeap.size();//最后输出的是没办法替换的房间数量就是同时存在的房间数量
    }
}
