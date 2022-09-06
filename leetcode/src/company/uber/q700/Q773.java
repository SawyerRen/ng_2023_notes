package company.uber.q700;

import java.util.*;

public class Q773 {
    int[][] arr = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        String start = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals("123450")) return res;
                List<String> nextList = getNext(poll);
                for (String s : nextList) {
                    if (visited.contains(s)) continue;
                    queue.add(s);
                    visited.add(s);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> getNext(String s) {
        int index = s.indexOf('0');
        List<String> list = new ArrayList<>();
        for (int i : arr[index]) {
            StringBuilder builder = new StringBuilder(s);
            builder.setCharAt(index, builder.charAt(i));
            builder.setCharAt(i, '0');
            list.add(builder.toString());
        }
        return list;
    }
}
