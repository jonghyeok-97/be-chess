package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawns;

    Board() {
        this.pawns = new ArrayList<>();
    }

    private Board(final List<Pawn> pawns) {
        this.pawns = pawns;
    }

    Board add(final Pawn pawn) {
        final List<Pawn> adding = new ArrayList<>(pawns);
        adding.add(pawn);
        return new Board(adding);
    }

    int size() {
        return pawns.size();
    }

    Pawn findPawn(final int position) {
        return pawns.get(position);
    }
}
