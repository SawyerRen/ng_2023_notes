package company.uber.q700;

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Q773 {
    int[][] arr = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(toStr(board));
        visited.add(toStr(board));
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals("123450")) return res;
                List<String> nextList = getNext(poll);
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

    private List<String> getNext(String s) {
        List<String> list = new ArrayList<>();
        int i = s.indexOf('0');
        for (int index : arr[i]) {
            StringBuilder builder = new StringBuilder(s);
            builder.setCharAt(i, builder.charAt(index));
            builder.setCharAt(index, '0');
            list.add(builder.toString());
        }
        return list;
    }

    private String toStr(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int[] row : board) {
            for (int i : row) {
                builder.append(i);
            }
        }
        return builder.toString();
    }
}
