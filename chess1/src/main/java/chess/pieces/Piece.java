package chess.pieces;

import java.util.Objects;

public class Piece {
    private final Color color;
    private final Symbol symbol;

    private Piece(final Color color, final Symbol symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Symbol.Pawn);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Symbol.Pawn);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Symbol.Knight);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Symbol.Knight);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Symbol.Rook);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Symbol.Rook);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Symbol.Bishop);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Symbol.Bishop);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Symbol.Queen);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Symbol.Queen);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Symbol.King);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Symbol.King);
    }

    public static Piece createEmpty() {
        return new Piece(Color.EMPTY, Symbol.NONE);
    }

    public String getSymbol() {
        return symbol.symbol();
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && symbol == piece.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, symbol);
    }
}
