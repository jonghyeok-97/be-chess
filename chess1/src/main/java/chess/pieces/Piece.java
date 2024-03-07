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

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, PieceType.Rook);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, PieceType.Rook);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, PieceType.Bishop);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, PieceType.Bishop);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, PieceType.Queen);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, PieceType.Queen);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, PieceType.King);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, PieceType.King);
    }

//    public boolean isSameColor(final Color color) throws ColorException{
//        if (color == null) {
//            throw new ColorException("color는" + color + "가 될 수 없습니다");
//        }
//        return this.color == color;
//    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
