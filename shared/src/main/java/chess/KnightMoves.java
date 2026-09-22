package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMoves {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();

        if (row < 7) {
            if (col < 8) {
                ChessPosition newPosition = new ChessPosition(row + 2, col + 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
            if (col > 1) {
                ChessPosition newPosition = new ChessPosition(row + 2, col - 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
        }

        if (row > 2) {
            if (col < 8) {
                ChessPosition newPosition = new ChessPosition(row - 2, col + 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
            if (col > 1) {
                ChessPosition newPosition = new ChessPosition(row - 2, col - 1);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
        }

        if (col < 7) {
            if (row < 8) {
                ChessPosition newPosition = new ChessPosition(row + 1, col + 2);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
            if (row > 1) {
                ChessPosition newPosition = new ChessPosition(row - 1, col + 2);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
        }

        if (col > 2) {
            if (row < 8) {
                ChessPosition newPosition = new ChessPosition(row + 1, col - 2);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
            if (row > 1) {
                ChessPosition newPosition = new ChessPosition(row - 1, col - 2);
                addMoves(board, myPosition, newPosition, possibleMoves);
            }
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
