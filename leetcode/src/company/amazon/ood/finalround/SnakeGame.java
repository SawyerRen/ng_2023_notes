package company.amazon.ood.finalround;

import java.util.LinkedList;

public class SnakeGame {
    class Unit {
        int row;
        int col;
        boolean empty;

        public Unit(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void setEmpty(boolean empty) {
            this.empty = empty;
        }
    }

    class Board {
        Unit[][] board;

        public Board(int m, int n) {
            board = new Unit[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = new Unit(i, j);
                }
            }
        }

        Unit get(int row, int col) {
            return board[row][col];
        }
    }

    enum GameStatus {
        WON, LOSE, GOING_ON
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    class Game {
        Board board;
        LinkedList<Unit> snake;
        LinkedList<Unit> food;
        int height;
        int width;
        GameStatus gameStatus;

        public Game(LinkedList<Unit> food, int height, int width) {
            this.food = food;
            this.height = height;
            this.width = width;
            board = new Board(height, width);
            snake.addLast(board.get(0, 0));
        }

        public void move(Direction direction) {
            if (gameStatus != GameStatus.GOING_ON) return;
            Unit head = snake.peekFirst();
            int row = head.row, col = head.col;
            switch (direction) {
                case UP:
                    row--;
                    break;
                case DOWN:
                    row++;
                    break;
                case LEFT:
                    col--;
                    break;
                case RIGHT:
                    col++;
                    break;
            }
            Unit tail = snake.removeLast();
            tail.setEmpty(true);
            if (row < 0 || row >= height || col < 0 || col >= width || !board.get(row, col).empty) {
                gameStatus = GameStatus.LOSE;
                return;
            }
            snake.addFirst(board.get(row, col));
            board.get(row, col).setEmpty(false);
            if (row == food.peekFirst().row && col == food.peekFirst().col) {
                snake.addLast(tail);
                tail.setEmpty(false);
            }
            if (food.isEmpty()) {
                gameStatus = GameStatus.WON;
            }
        }
    }
}
