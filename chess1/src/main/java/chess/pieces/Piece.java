package chess.pieces;

import java.util.Objects;
import java.util.Optional;

public class Piece {
    private final Color color;
    private final PieceType type;

    private Piece(final Color color, final PieceType type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, PieceType.Pawn);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, PieceType.Pawn);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, PieceType.Knight);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, PieceType.Knight);
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }
}
