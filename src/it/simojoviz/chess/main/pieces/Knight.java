package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.util.Move;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean checkMove(int startXcord, int startYcord, int endXcord, int endYcord) {
        return false;
    }
}
