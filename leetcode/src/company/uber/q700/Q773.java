package company.uber.q700;

import java.util.*;

public class Q773 {
    static String SUCCESS = "123450";

    public static int slidingPuzzle(int[][] board) {
        String start = toStr(board);
        Queue<int[][]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(board);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                board = queue.poll();
                String s = toStr(board);
                if (s.equals(SUCCESS)) return res;
                List<int[][]> nextList = getNext(board);
                for (int[][] nextBoard : nextList) {
                    if (visited.contains(toStr(nextBoard))) continue;
                    queue.add(nextBoard);
                    visited.add(toStr(nextBoard));
                }
            }
            res++;
        }
        return -1;
    }

    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static List<int[][]> getNext(int[][] board) {
        List<int[][]> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= 2 || y < 0 || y >= 3) continue;
                        int[][] newBoard = new int[2][3];
                        for (int k = 0; k < 2; k++) {
                            System.arraycopy(board[k], 0, newBoard[k], 0, 3);
                        }
                        int t = newBoard[i][j];
                        newBoard[i][j] = newBoard[x][y];
                        newBoard[x][y] = t;
                        list.add(newBoard);
                    }
                    return list;
                }
            }
        }
        return list;
    }

    private static String toStr(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int[] row : board) {
            for (int i : row) {
                builder.append(i);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(slidingPuzzle(board));
    }
}
