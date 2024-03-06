package chess;

import chess.pieces.Pawn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private final List<Pawn> pawns;

    Board() {
        this.pawns = new ArrayList<>();
    }

    private Board(final List<Pawn> pawns) {
        this.pawns = pawns;
    }

    Board initialize() {
        final List<Pawn> blackPawns = IntStream.rangeClosed(1, 8)
                .mapToObj(i -> Pawn.createBlackPawn())
                .collect(Collectors.toList());
        final List<Pawn> whitePawns = IntStream.rangeClosed(1, 8)
                .mapToObj(i -> Pawn.createWhitePawn())
                .toList();
        blackPawns.addAll(whitePawns);
        return new Board(blackPawns);
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
