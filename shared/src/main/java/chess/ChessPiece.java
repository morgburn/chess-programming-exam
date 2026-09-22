package chess;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if (type == PieceType.BISHOP) {
            BishopMoves moves = new BishopMoves();
            return moves.pieceMoves(board, myPosition);
        }
        if (type == PieceType.KING) {
            KingMoves moves = new KingMoves();
            return moves.pieceMoves(board, myPosition);
        }
        if (type == PieceType.ROOK) {
            RookMoves moves = new RookMoves();
            return moves.pieceMoves(board, myPosition);
        }
        if (type == PieceType.KNIGHT) {
            KnightMoves moves = new KnightMoves();
            return moves.pieceMoves(board, myPosition);
        }
        if (type == PieceType.QUEEN) {
            QueenMoves moves = new QueenMoves();
            return moves.pieceMoves(board, myPosition);
        }
        if (type == PieceType.PAWN) {
            PawnMoves moves = new PawnMoves();
            return moves.pieceMoves(board, myPosition);
        }
        return List.of();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }
}
