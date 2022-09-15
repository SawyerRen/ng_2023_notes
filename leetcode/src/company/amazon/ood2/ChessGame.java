package company.amazon.ood2;

public class ChessGame {
    abstract class Piece {
        boolean isKilled;
        boolean white;

        abstract boolean camMove(Board board, Unit start, Unit end);
    }

    class Unit {
        int row;
        int col;
        Piece piece;
    }

    class Board {
        Unit[][] board;

        public Board() {
            // initialize the board
        }
    }

    class Player {
        String name;
        boolean whiteSide;
    }

    enum GameStatus {
        P1, P2, Going
    }

    class Game {
        Player p1, p2;
        Board board;
        GameStatus gameStatus;
        Player currentTurn;

        public Game(Player p1, Player p2) {
            this.p1 = p1;
            this.p2 = p2;
            board = new Board();
            gameStatus = GameStatus.Going;
            if (p1.whiteSide) currentTurn = p1;
            else currentTurn = p2;
        }

        boolean makeMove(Player player, int startRow, int startCol, int endRow, int endCol) {
            if (player != this.currentTurn) return false;
            Unit startUnit = board.board[startRow][startCol];
            Unit endUnit = board.board[endRow][endCol];
            Piece piece = startUnit.piece;
            if (piece == null || piece.isKilled || piece.white != player.whiteSide) return false;
            if (!piece.camMove(board, startUnit, endUnit)) return false;
            Piece endPiece = endUnit.piece;
            if (endPiece != null && endPiece.white == player.whiteSide) return false;
            if (endPiece != null) {
                endPiece.isKilled = true;
            }
            startUnit.piece = null;
            endUnit.piece = piece;
            if (player == p1) {
                p2 = currentTurn;
            } else {
                p1 = currentTurn;
            }
            return true;
        }
    }
}
