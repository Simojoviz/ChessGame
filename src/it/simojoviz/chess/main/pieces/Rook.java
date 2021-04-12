package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.util.Move;

public class Rook extends Piece{

    public Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean checkMove(int startXcord, int startYcord, int endXcord, int endYcord) {
        return false;
    }
}
