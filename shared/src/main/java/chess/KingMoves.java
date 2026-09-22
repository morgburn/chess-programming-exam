package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMoves {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();

        if (row < 8) {
            ChessPosition newPosition = new ChessPosition(row + 1, col);
            addMoves(board, myPosition, newPosition, possibleMoves);
            if (col < 8) {
                newPosition = new ChessPosition(row + 1, col + 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
            if (col > 1) {
                newPosition = new ChessPosition(row + 1, col - 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
        }

        if (row > 1) {
            ChessPosition newPosition = new ChessPosition(row - 1, col);
            addMoves(board, myPosition, newPosition, possibleMoves);
            if (col < 8) {
                newPosition = new ChessPosition(row - 1, col + 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
            if (col > 1) {
                newPosition = new ChessPosition(row - 1, col - 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
        }

        if (col < 8) {
            ChessPosition newPosition = new ChessPosition(row, col + 1);
            addMoves(board, myPosition, newPosition, possibleMoves);
        }

        if (col > 1) {
            ChessPosition newPosition = new ChessPosition(row, col - 1);
            addMoves(board, myPosition, newPosition, possibleMoves);
        }

        return possibleMoves;
    }

    void addMoves(ChessBoard board, ChessPosition myPosition, ChessPosition newPosition, Collection<ChessMove> possibleMoves) {
        if (board.getPiece(newPosition) == null) {
            possibleMoves.add(new ChessMove(myPosition, newPosition, null));
        } else if (board.getPiece(newPosition).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
            possibleMoves.add(new ChessMove(myPosition, newPosition, null));
        }
    }
}
