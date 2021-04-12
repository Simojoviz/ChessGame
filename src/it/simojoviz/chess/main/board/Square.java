package it.simojoviz.chess.main.board;

import it.simojoviz.chess.main.pieces.Piece;

public class Square {

    private Piece piece;

    private int xcord;
    private int ycord;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }
}
