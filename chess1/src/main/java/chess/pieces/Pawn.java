package chess.pieces;

public class Pawn {
    private final Color color;

    private Pawn(final Color color) {
        this.color = color;
    }

    public static Pawn createWhitePawn() {
        return new Pawn(Color.WHITE);
    }

    public static Pawn createBlackPawn() {
        return new Pawn(Color.BLACK);
    }

//    public Color getColor() {
//        return color;
//    }
}
