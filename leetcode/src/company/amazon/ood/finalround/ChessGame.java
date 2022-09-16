package company.amazon.ood.finalround;

import javax.swing.border.EmptyBorder;

public class ChessGame {
    class Player {
        String name;
        boolean whiteSide;

        public Player(String name, boolean whiteSide) {
            this.name = name;
            this.whiteSide = whiteSide;
        }
    }

    abstract class Piece {
        boolean whiteSide;

        abstract boolean canMove(Unit start, Unit end);
    }

    class Unit {
        int row;
        int col;
        Piece piece;

        public Unit(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    class Board {
        Unit[][] board;
    }

    class Game {
        Player p1, p2;
        boolean end;
        Player currentTurn;
        Board board;

        void makeMove(Player player, int startRow, int startCol, int endRow, int endCol) {
            Unit unit = board.board[startRow][startCol];
            Piece startPiece = unit.piece;
            Unit endUnit = board.board[endRow][endCol];
            if (player != currentTurn || end || startPiece.canMove(unit, endUnit)) return;
            unit.piece = null;
            if (endUnit.piece != null) {
                // check whether game end
            }
            endUnit.piece = startPiece;

            if (currentTurn == p1) {
                currentTurn = p2;
            } else {
                currentTurn = p1;
            }
        }
    }
}
