package company.amazon.ood2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MineSweeper {
    enum UnitStatus {
        UN_SHOWN_MINE, SHOWN_MINE, UN_SHOWN_BLANK,
        SHOWN_BLANK, DIGIT
    }

    class Unit {
        int row;
        int col;
        UnitStatus status;
        int digit;

        public Unit(int row, int col, UnitStatus status) {
            this.row = row;
            this.col = col;
            this.status = status;
        }
    }

    class Board {
        int m;
        int n;
        Unit[][] units;
        int nonMineCount = 0;

        public Board(int m, int n) {
            this.m = m;
            this.n = n;
            Random random = new Random();
            units = new Unit[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    UnitStatus status = random.nextInt(10) != 0 ? UnitStatus.UN_SHOWN_BLANK : UnitStatus.UN_SHOWN_MINE;
                    if (status == UnitStatus.UN_SHOWN_BLANK) nonMineCount++;
                    units[i][j] = new Unit(i, j, status);
                }
            }
        }

        public Unit getUnit(int x, int y) {
            return units[x][y];
        }

        public boolean canMove(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n) return false;
            return units[x][y].status == UnitStatus.UN_SHOWN_BLANK || units[x][y].status == UnitStatus.UN_SHOWN_MINE;
        }
    }

    enum GameStatus {
        LOSE, WIN, GOING
    }

    class Game {
        int m;
        int n;
        Board board;
        GameStatus status;

        public Game(int m, int n) {
            this.m = m;
            this.n = n;
            board = new Board(m, n);
            status = GameStatus.GOING;
        }

        public void makeMove(int x, int y) {
            if (status != GameStatus.GOING) return;
            if (!board.canMove(x, y)) return;
            Unit unit = board.getUnit(x, y);
            if (unit.status == UnitStatus.UN_SHOWN_MINE) {
                unit.status = UnitStatus.SHOWN_MINE;
                status = GameStatus.LOSE;
                return;
            }
            updateBoard(x, y);
            if (board.nonMineCount == 0) {
                status = GameStatus.WIN;
            }
        }

        private void updateBoard(int row, int col) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{row, col});
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                board.nonMineCount--;
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int x = poll[0] + i, y = poll[1] + j;
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        if (board.getUnit(x, y).status == UnitStatus.UN_SHOWN_MINE) count++;
                    }
                }
                if (count > 0) {
                    board.getUnit(poll[0], poll[1]).digit = (char) (count + '0');
                    board.getUnit(poll[0], poll[1]).status = UnitStatus.DIGIT;
                    continue;
                }
                board.getUnit(poll[0], poll[1]).status = UnitStatus.SHOWN_BLANK;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int x = poll[0] + i, y = poll[1] + j;
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        if (board.getUnit(x, y).status == UnitStatus.UN_SHOWN_BLANK) {
                            board.getUnit(x, y).status = UnitStatus.SHOWN_BLANK;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
}
