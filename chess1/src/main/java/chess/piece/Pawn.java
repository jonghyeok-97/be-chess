package chess.piece;

class Pawn {
    private final Color color;

    Pawn(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("색깔을 정해야 합니다.");
        }
        this.color = color;
    }

    Color getColor() {
        return color;
    }
}
