package it.simojoviz.chess.main.pieces;

import it.simojoviz.chess.main.board.Board;
import it.simojoviz.chess.main.board.Square;
import it.simojoviz.chess.main.util.Move;

public abstract class Piece {

    public enum Color{
        WHITE, BLACK
    }

    public enum Type{
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    protected final Color color;
    protected final Type type;
    private boolean captured;

    public Piece(Color color, Type type) {
        this.color = color;
        this.captured = false;
        this.type = type;
    }

    public abstract boolean checkMove(int startXcord, int startYcord, int endXcord, int endYcord);

    protected boolean auxValidMove(Move move) {
        Square startSquare = move.getStartSquare();
        Square endSquare = move.getEndSquare();
        int startXcord = startSquare.getXcord();
        int startYcord = startSquare.getYcord();
        int endXcord = endSquare.getXcord();
        int endYcord = endSquare.getYcord();
        if (startSquare.getPiece() == null || endSquare.getPiece().getColor() == startSquare.getPiece().getColor()
                || startSquare.equals(endSquare) || endXcord < 0 || endXcord > 7 || endYcord < 0
                || endYcord > 7 || Math.abs(endYcord - startYcord) != Math.abs(endXcord - startXcord))
            return false;



        int kingXcord = Board.getWhiteKingSquare().getXcord();
        int kingYcord = Board.getWhiteKingSquare().getYcord();

        if (startXcord == kingXcord && endXcord != kingXcord) {

            for (int i = kingYcord+1; i < 8 ; i++) {
                Piece piece = Board.getSquare(kingXcord, i).getPiece();
                if (piece != null && piece != this && !(this.getColor().equals(piece.getColor())) &&
                        (piece.type == Type.ROOK || piece.type == Type.QUEEN))
                    return false;
            }
            for (int i = kingYcord-1; i >= 0 ; i--) {
                Piece piece = Board.getSquare(kingXcord, i).getPiece();
                if (piece != null && piece != this && !(this.getColor().equals(piece.getColor())) &&
                        (piece.type == Type.ROOK || piece.type == Type.QUEEN))
                    return false;
            }
        }
        if (startYcord == kingYcord && endYcord != kingYcord) {

            for (int i = kingXcord + 1; i < 8; i++) {
                Piece piece = Board.getSquare(i, kingYcord).getPiece();
                if (piece != null && piece != this && !(this.getColor().equals(piece.getColor())) &&
                        (piece.type == Type.ROOK || piece.type == Type.QUEEN))
                    return false;
            }
            for (int i = kingXcord - 1; i >= 0; i--) {
                Piece piece = Board.getSquare(i, kingYcord).getPiece();
                if (piece != null && piece != this && !(this.getColor().equals(piece.getColor())) &&
                        (piece.type == Type.ROOK || piece.type == Type.QUEEN))
                    return false;
            }
        }

        if (Math.abs(startXcord - kingXcord) == Math.abs(startYcord - kingYcord)) {

        }
    }

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
