package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.util.Move;

public abstract class Piece {

    public enum Color{
        WHITE, BLACK
    }

    private Color color;

    private Boolean captured = false;



    public abstract Boolean isValidMove(Move move);

    public Boolean getCaptured() {
        return captured;
    }

    public void setCaptured(Boolean captured) {
        this.captured = captured;
    }

    public Color getColor() {
        return color;
    }

}
