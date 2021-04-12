package it.simojoviz.chess.main.util;

import it.simojoviz.chess.main.board.Square;
import it.simojoviz.chess.main.pieces.Piece;

public class Move {

    private static int count = 0;

    public final int moveNumber;

    private Square startSquare;

    private Square endSquare;

    private Piece startPiece;

    private Piece capturedPiece;



    public Piece getStartPiece() {
        return startPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public Square getStartSquare() {
        return startSquare;
    }

    public Square getEndSquare() {
        return endSquare;
    }

}
