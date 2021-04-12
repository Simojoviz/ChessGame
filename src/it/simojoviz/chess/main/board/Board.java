package it.simojoviz.chess.main.board;

import it.simojoviz.chess.main.pieces.Piece;
import it.simojoviz.chess.main.util.InvalidMoveException;
import it.simojoviz.chess.main.util.Move;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Board {

    private static final Square[][] board = new Square[8][8];

    private static final Queue<Move> moveLog = new LinkedList<>();
    private static final Collection<Piece> captured= new LinkedList<>();
    private static Square whiteKingSquare;
    private static Square blackKingSquare;

    public static void makeMove(Move move) throws InvalidMoveException {
        Piece startPiece = move.getStartPiece();
        Piece capturedPiece = move.getCapturedPiece();
        if (move.isValid()) {
            moveLog.add(move);
            if (capturedPiece != null) {
                capturedPiece.setCaptured(true);
                captured.add(capturedPiece);
            }
            move.getStartSquare().setPiece(null);
            move.getEndSquare().setPiece(startPiece);

            return;
        }

        throw new InvalidMoveException();
    }


    public static Square getSquare(int xcord, int ycord) {
        return board[xcord][ycord];
    }

    public static Square getWhiteKingSquare() {
        return whiteKingSquare;
    }

    public static Square getBlackKingSquare() {
        return blackKingSquare;
    }

    public static void setWhiteKingSquare(Square whiteKingSquare) {
        Board.whiteKingSquare = whiteKingSquare;
    }

    public static void setBlackKingSquare(Square blackKingSquare) {
        Board.blackKingSquare = blackKingSquare;
    }
}
