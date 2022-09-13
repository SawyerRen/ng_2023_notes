package company.amazon.q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q353 {
    class SnakeGame {
        int width;
        int height;
        int[][] board;
        int[][] food;
        int foodIndex = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        boolean end = false;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            board = new int[height][width];
            queue.addLast(new int[]{0, 0});
            board[0][0] = 1;
            if (food[0][0] == 0 && food[0][1] == 0) foodIndex++;
        }

        public int move(String direction) {
            if (end) return -1;
            int[] head = queue.peekFirst();
            int i = head[0], j = head[1];
            switch (direction) {
                case "R":
                    j++;
                    break;
                case "U":
                    i--;
                    break;
                case "L":
                    j--;
                    break;
                case "D":
                    i++;
                    break;
            }
            int[] tail = queue.getLast();
            board[tail[0]][tail[1]] = 0;
            if (i < 0 || i >= height || j < 0 || j >= width || board[i][j] == 1) {
                end = true;
                return -1;
            }
            queue.addFirst(new int[]{i, j});
            board[i][j] = 1;
            if (foodIndex < food.length && i == food[foodIndex][0] && j == food[foodIndex][1]) {
                foodIndex++;
                board[tail[0]][tail[1]] = 1;
            } else {
                queue.removeLast();
            }
            return foodIndex;
        }
    }
}
