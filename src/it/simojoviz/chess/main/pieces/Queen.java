package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.util.Move;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean checkMove(int startXcord, int startYcord, int endXcord, int endYcord) {
        return false;
    }
}
