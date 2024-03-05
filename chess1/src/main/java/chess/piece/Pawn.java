package chess.piece;

class Pawn {
    private final Color color;

    private Pawn(final Color color) {
        this.color = color;
    }

    static Pawn createDefaultPawn() {
        return new Pawn(Color.WHITE);
    }

    static Pawn createPawn(final Color color) {
        return new Pawn(color);
    }

    Color getColor() {
        return color;
    }
}
