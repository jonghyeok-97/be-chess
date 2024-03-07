package chess.pieces;

public enum Symbol {
    Pawn("P"),
    Knight("N"),
    Rook("R"),
    Bishop("B"),
    Queen("Q"),
    King("K"),
    NONE(".");

    private final String symbol;

    Symbol(final String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

}
