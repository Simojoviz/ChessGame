package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.board.Board;
import it.simojoviz.chess.main.board.Square;
import it.simojoviz.chess.main.util.Move;

public class Bishop extends Piece{

    public Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public boolean checkMove(int startXcord, int startYcord, int endXcord, int endYcord) {
        if (Math.abs(endYcord - startYcord) != Math.abs(endXcord - startXcord))
            return false;

        if (endXcord > startXcord && endYcord > startYcord) {
            for (int i = 1; i < Math.abs(endXcord - startXcord); i++)
                if (Board.getSquare(startXcord+i, startYcord+i).getPiece() != null)
                    return false;
        } else if (endXcord > startXcord) {
            for (int i = 1; i < Math.abs(endXcord - startXcord); i++)
                if (Board.getSquare(startXcord+i, startYcord-i).getPiece() != null)
                    return false;
        } else if (endYcord > startYcord) {
            for (int i = 1; i < Math.abs(endXcord - startXcord); i++)
                if (Board.getSquare(startXcord-i, startYcord+i).getPiece() != null)
                    return false;
        } else {
            for (int i = 1; i < Math.abs(endXcord - startXcord); i++)
                if (Board.getSquare(startXcord-i, startYcord-i).getPiece() != null)
                    return false;
        }

        return true;
    }
}
