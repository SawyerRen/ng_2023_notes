package company.bloomberg.mj.nontag;

import java.util.*;

/**
During each step, you can perform the following two computation:
n = n * 2
n = n // 3
You start with 1, what's the min step you take to reach target value t?
*/
public class MinimumOperationToBecome1 {
    // 标准的BFS写法，对于每一个数，都有两种选择：乘2或者除以3
     // follow up 这个函数如果多次call怎么办？建一个hashmap保存结果
    int solution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        visited.add(n);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == 1) return res;
                if (!visited.contains(poll * 2)) {
                    visited.add(poll * 2);
                    queue.add(poll * 2);
                }
                if (poll % 3 == 0 && !visited.contains(poll / 3)) {
                    visited.add(poll / 3);
                    queue.add(poll / 3);
                }
            }
        }
        return -1;
    }
}
