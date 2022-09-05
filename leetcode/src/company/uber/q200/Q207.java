package company.uber.q200;

import java.util.*;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] preCount = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], new HashSet<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
            preCount[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer c1 = queue.poll();
            count++;
            if (map.containsKey(c1)) {
                for (Integer c2 : map.get(c1)) {
                    preCount[c2]--;
                    if (preCount[c2] == 0) queue.add(c2);
                }
            }
        }
        return count == numCourses;
    }
}
