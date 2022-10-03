package company.uber.lastround;

import java.util.*;

public class Q773 {
    int[][] arr = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        String s = "";
        for (int[] row : board) {
            for (int i : row) {
                s += i;
            }
        }
        queue.add(s);
        int res = 0;
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals("123450")) return res;
                List<String> nextList = helper(poll);
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

    private List<String> helper(String s) {
        List<String> list = new ArrayList<>();
        int index = s.indexOf('0');
        for (int i : arr[index]) {
            StringBuilder builder = new StringBuilder(s);
            builder.setCharAt(index, s.charAt(i));
            builder.setCharAt(i, '0');
            list.add(builder.toString());
        }
        return list;
    }
}
