package company.amazon.q300;

import java.util.*;

public class Q353 {
    class SnakeGame {
        int width;
        int height;
        int[][] food;
        int foodIndex = 0;
        Set<Integer> visited = new HashSet<>();
        LinkedList<int[]> queue = new LinkedList<>();
        boolean end = false;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            visited.add(0);
            queue.add(new int[]{0, 0});
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
            int[] last = queue.peekLast();
            visited.remove(last[0] * width + last[1]);
            if (i < 0 || i >= height || j < 0 || j >= width || visited.contains(i * width + j)) {
                end = true;
                return -1;
            }
            queue.addFirst(new int[]{i, j});
            visited.add(i * width + j);
            if (foodIndex < food.length && i == food[foodIndex][0] && j == food[foodIndex][1]) {
                foodIndex++;
                visited.add(last[0] * width + last[1]);
            } else {
                queue.pollLast();
            }
            return foodIndex;
        }
    }
}
