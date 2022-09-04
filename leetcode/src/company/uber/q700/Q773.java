package company.uber.q700;

import java.util.*;

public class Q773 {
    int[][] arr = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int i : row) {
                start.append(i);
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start.toString());
        visited.add(start.toString());
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals("123450")) return res;
                List<String> nextList = getNextList(poll);
                for (String next : nextList) {
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> getNextList(String poll) {
        List<String> list = new ArrayList<>();
        int index = poll.indexOf("0");
        for (int i : arr[index]) {
            StringBuilder builder = new StringBuilder(poll);
            builder.setCharAt(index, builder.charAt(i));
            builder.setCharAt(i, '0');
            list.add(builder.toString());
        }
        return list;
    }
}
