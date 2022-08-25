package company.amazon.ood.chess;

import java.util.List;

abstract class Piece {
    boolean killed = false;
    boolean white = false;

    public Piece(boolean white) {
        this.white = white;
    }

    abstract boolean canMove(Board board, Box start, Box end);
}

class King extends Piece {

    public King(boolean white) {
        super(white);
    }

    @Override
    boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}

class Box {
    int x;
    int y;
    Piece piece;

    public Box(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}

class Board {
    Box[][] boxes;

    public Board() {
        resetBoard();
    }

    public Box getBox(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        }
        return boxes[x][y];
    }

    public void resetBoard() {
        // initialize board;
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
    Box start;
    Box end;
    Piece pieceMoved;
    Piece pieceKilled;

    public Move(Player player, Box start, Box end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.piece;
    }
}

enum GameStatus {
    ACTIVE, BLACK_WIN, WHITE_WIN, FORFIET, STALEMATE, RESIGNATION
}

public class ChessGame {
    Player[] players;
    Board board;
    Player currentTurn;
    GameStatus status;
    List<Move> movesPlayed;

    void initialize(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board.resetBoard();
        if (p1.whiteSide) currentTurn = p1;
        else currentTurn = p2;
        movesPlayed.clear();
    }

    boolean isEnd() {
        return this.status != GameStatus.ACTIVE;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
        Box startBox = board.getBox(startX, startY);
        Box endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return makeMove(player, move);
    }

    private boolean makeMove(Player player, Move move) {
        Piece sourcePiece = move.pieceMoved;
        if (sourcePiece == null) return false;
        if (player != currentTurn) return false;
        if (sourcePiece.white != player.whiteSide) return false;
        if (!sourcePiece.canMove(board, move.start, move.end)) return false;

        Piece destPiece = move.end.piece;
        if (destPiece != null) {
            destPiece.killed = true;
            move.pieceKilled = destPiece;
        }
        movesPlayed.add(move);
        if (destPiece instanceof King) {
            if (player.whiteSide) {
                this.status = GameStatus.WHITE_WIN;
            } else {
                this.status = GameStatus.BLACK_WIN;
            }
        }
        if (currentTurn == players[0]) {
            currentTurn = players[1];
        } else {
            currentTurn = players[0];
        }
        return true;
    }
}
