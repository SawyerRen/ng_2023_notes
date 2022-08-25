package company.amazon.ood;

import java.util.List;

class Spot {
    Piece piece;
    int x;
    int y;

    public Spot(Piece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }
}

abstract class Piece {
    boolean killed = false;
    boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    abstract boolean canMove(Board board, Spot start, Spot end);
}

class Board {
    Spot[][] boxes;

    public Board() {
        // initialize the board
    }

    Spot getBox(int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }
        return boxes[x][y];
    }
}

class Player {
    boolean whiteSide;

    public Player(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }
}

class Move {
    Player player;
    Spot start;
    Spot end;
    Piece pieceMoved;
    Piece pieceKilled;

    public Move(Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        pieceMoved = start.piece;
    }
}

enum GameStatus {
    ACTIVE,
    BLACK_WIN,
    WHITE_WIN,
}

public class ChessGame {
    Player p1;
    Player p2;
    Board board;
    Player currentTurn;
    GameStatus status;
    List<Move> moves;

    public ChessGame(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        board = new Board();
        if (p1.whiteSide) this.currentTurn = p1;
        else currentTurn = p2;
    }

    boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Spot start = board.getBox(startX, startY);
        Spot end = board.getBox(endX, endY);
        Move move = new Move(player, start, end);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player) {
        Piece startPiece = move.start.piece;
        if (startPiece == null) return false;
        if (player != currentTurn) return false;
        if (startPiece.white != player.whiteSide) return false;
        if (!startPiece.canMove(board, move.start, move.end)) return false;

        Piece endPiece = move.end.piece;
        if (endPiece != null) {
            endPiece.killed = true;
            move.pieceKilled = endPiece;
        }
        moves.add(move);
        // move to dest

        if (this.currentTurn == p1) {
            currentTurn = p2;
        } else {
            currentTurn = p1;
        }
        return true;
    }
}
