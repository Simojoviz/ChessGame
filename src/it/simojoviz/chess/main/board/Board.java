package it.simojoviz.chess.main.board;

import it.simojoviz.chess.main.pieces.Piece;
import it.simojoviz.chess.main.util.Move;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Board {

    private static final Square[][] board = new Square[8][8];

    private static final Queue<Move> moveLog = new LinkedList<>();
    private static final Collection<Piece> captured= new LinkedList<>();

    public static Square getSquare(int xcord, int ycord) {
        return board[xcord][ycord];
    }

    public static void makeMove(Move move) {
        Piece startPiece = move.getStartPiece();
        Piece capturedPiece = move.getCapturedPiece();
        if (startPiece.isValidMove(move)) {
            moveLog.add(move);
            if (capturedPiece != null) {
                capturedPiece.setCaptured(true);
                captured.add(capturedPiece);
            }
            move.getStartSquare().setPiece(null);
            move.getEndSquare().setPiece(startPiece);
        }

    }
}
