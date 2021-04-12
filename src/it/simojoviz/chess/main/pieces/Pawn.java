package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.util.Move;

public class Pawn extends Piece{
    public Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public boolean checkMove(int startXcord, int startYcord, int endXcord, int endYcord) {
        return false;
    }
}
