package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.board.Board;
import it.simojoviz.chess.main.util.Move;

public class King extends Piece{
    public King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean checkMove(int startXcord, int startYcord, int endXcord, int endYcord) {
        return false;
    }
}
