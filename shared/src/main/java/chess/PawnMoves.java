package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMoves {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        int newRow;
        int start;
        int end;
        int newNewRow;
        boolean validMove = false;

        if (board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
            newRow = row + 1;
            newNewRow = row + 2;
            start = 2;
            end = 8;
            if (row < 8) {
                validMove = true;
            }
        } else {
            newRow = row - 1;
            newNewRow = row - 2;
            start = 7;
            end = 1;
            if (row > 1) {
                validMove = true;
            }
        }

        if (validMove) {
            ChessPosition newPosition = new ChessPosition(newRow, col);
            if (board.getPiece(newPosition) == null) {
                if (newRow == end) {
                    addPromotionPiece(myPosition, newPosition, possibleMoves);
                } else {
                    possibleMoves.add(new ChessMove(myPosition, newPosition, null));
                }
                if (row == start) {
                    newPosition = new ChessPosition(newNewRow, col);
                    if (board.getPiece(newPosition) ==  null) {
                        possibleMoves.add(new ChessMove(myPosition, newPosition, null));
                    }
                }
            }
            if (col < 8) {
                newPosition = new ChessPosition(newRow, col + 1);
                addCaptureMove(board, myPosition, possibleMoves, newRow, end, newPosition);
            }
            if (col > 1) {
                newPosition = new ChessPosition(newRow, col - 1);
                addCaptureMove(board, myPosition, possibleMoves, newRow, end, newPosition);
            }
        }

        return possibleMoves;
    }

    private void addCaptureMove(ChessBoard board, ChessPosition myPosition, Collection<ChessMove> possibleMoves, int newRow, int end, ChessPosition newPosition) {
        if (board.getPiece(newPosition) != null) {
            if (board.getPiece(newPosition).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                if (newRow == end) {
                    addPromotionPiece(myPosition, newPosition, possibleMoves);
                } else {
                    possibleMoves.add(new ChessMove(myPosition, newPosition, null));
                }
            }
        }
    }

    private void addPromotionPiece(ChessPosition myPosition, ChessPosition newPosition, Collection<ChessMove> possibleMoves) {
        possibleMoves.add(new ChessMove(myPosition, newPosition, ChessPiece.PieceType.QUEEN));
        possibleMoves.add(new ChessMove(myPosition, newPosition, ChessPiece.PieceType.BISHOP));
        possibleMoves.add(new ChessMove(myPosition, newPosition, ChessPiece.PieceType.KNIGHT));
        possibleMoves.add(new ChessMove(myPosition, newPosition, ChessPiece.PieceType.ROOK));
    }
}
