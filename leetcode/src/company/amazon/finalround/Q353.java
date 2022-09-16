package company.amazon.finalround;

import java.util.LinkedList;

public class Q353 {
    class SnakeGame {
        int width;
        int height;
        int[][] board;
        int[][] food;
        int foodIndex;
        boolean end;
        LinkedList<int[]> snake;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            board = new int[height][width];
            snake = new LinkedList<>();
            snake.addLast(new int[]{0, 0});
            board[0][0] = 1;
        }

        public int move(String direction) {
            if (end) return -1;
            int[] head = snake.peekFirst();
            int i = head[0], j = head[1];
            switch (direction) {
                case "R":
                    j++;
                    break;
                case "L":
                    j--;
                    break;
                case "U":
                    i--;
                    break;
                case "D":
                    i++;
                    break;
            }
            int[] tail = snake.removeLast();
            board[tail[0]][tail[1]] = 0;
            if (i < 0 || i >= height || j < 0 || j >= width || board[i][j] == 1) {
                end = true;
                return -1;
            }
            if (foodIndex < food.length && i == food[foodIndex][0] && j == food[foodIndex][1]) {
                foodIndex++;
                snake.addLast(tail);
                board[tail[0]][tail[1]] = 1;
            }
            snake.addFirst(new int[]{i, j});
            board[i][j] = 1;
            return foodIndex;
        }
    }
}
