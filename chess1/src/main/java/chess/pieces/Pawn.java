package chess.pieces;

public class Pawn {
    private final Color color;

    private Pawn(final Color color) {
        this.color = color;
    }

    public static Pawn createDefaultPawn() {
        return new Pawn(Color.WHITE);
    }

    public static Pawn createPawn(final Color color) {
        return new Pawn(color);
    }

    public Color getColor() {
        return color;
    }
}
