package it.simojoviz.chess.main.util;

import it.simojoviz.chess.main.board.Board;
import it.simojoviz.chess.main.board.Square;
import it.simojoviz.chess.main.pieces.Piece;

public class Move {

    private static int count = 0;

    public final int moveNumber;

    private Square startSquare;

    private Square endSquare;

    private Piece startPiece;

    private Piece endPiece;

    private Piece capturedPiece;

    public Move(int startXcord, int startYcord, int endXcord, int endYcord) {
        this.moveNumber = count++;
        this.startSquare = Board.getSquare(startXcord, startYcord);
        this.endSquare = Board.getSquare(endXcord, endYcord);
        this.startPiece = this.startSquare.getPiece();
        this.endPiece = this.endSquare.getPiece();
        this.capturedPiece = this.endSquare.getPiece();
    }

    public boolean isValid() {
        int startXcord = startSquare.getXcord();
        int startYcord = startSquare.getYcord();
        int endXcord = endSquare.getXcord();
        int endYcord = endSquare.getYcord();
        int kingXcord = (startPiece.getColor() == Piece.Color.WHITE) ? Board.getWhiteKingSquare().getXcord() : Board.getBlackKingSquare().getXcord();
        int kingYcord = (startPiece.getColor() == Piece.Color.WHITE) ? Board.getWhiteKingSquare().getYcord() : Board.getBlackKingSquare().getYcord();

        if (startPiece == null || endPiece.getColor() == startPiece.getColor() || (endXcord == startXcord && endYcord == startYcord)
            || endXcord < 0 || endXcord > 7 || endYcord < 0 || endYcord > 7 || !startPiece.checkMove(startXcord, startYcord, endXcord, endYcord))
            return false;

        Piece piece;
        int i = kingXcord+1;
        while (i < 8 && i != endXcord) {
            piece = Board.getSquare(i, kingYcord).getPiece();
            if (piece != null && piece != startPiece) {
                if (piece.getColor() == startPiece.getColor())
                    break;

                return false;
            }
            i++;
        }

        i = kingXcord-1;
        while (i > 0 && i != endXcord) {
            piece = Board.getSquare(i, kingYcord).getPiece();
            if (piece != null && piece != startPiece) {
                if (piece.getColor() == startPiece.getColor())
                    break;

                return false;
            }
            i--;
        }

        i = kingYcord+1;
        while (i < 8 && i != endYcord) {
            piece = Board.getSquare(kingXcord , i).getPiece();
            if (piece != null && piece != startPiece) {
                if (piece.getColor() == startPiece.getColor())
                    break;

                return false;
            }
            i++;
        }

        i = kingYcord-1;
        while (i > 0 && i != endYcord) {
            piece = Board.getSquare(kingXcord , i).getPiece();
            if (piece != null && piece != startPiece) {
                if (piece.getColor() == startPiece.getColor())
                    break;

                return false;
            }
            i--;
        }

        if (Math.abs(startXcord - kingXcord) == Math.abs(startYcord - kingYcord)) {
            int delta = Math.abs(endXcord - startXcord);
            
            for (i = 1; i < delta ; i++) {
                piece = Board.getSquare(kingXcord + i, kingYcord + i).getPiece();
                if (piece != null && piece != startPiece)
                    return false;
            }
        }

    }



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
