package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {
    private final List<Pawn> pawns;

    Board() {
        this.pawns = new ArrayList<>();
    }

    private Board(final List<Pawn> pawns) {
        this.pawns = pawns;
    }

    Board initialize() {
        final List<Pawn> pawns = Stream.concat(
                IntStream.rangeClosed(1, 8).mapToObj(i -> Pawn.createWhitePawn()),
                IntStream.rangeClosed(1, 8).mapToObj(i -> Pawn.createBlackPawn())
        ).toList();
        return new Board(pawns);
    }

    void print() {
        final String blankRow = ".".repeat(8);
        final StringBuilder boardState = new StringBuilder();
        IntStream.rangeClosed(1, 8)
                .forEach(i -> {
                    if(i == 2) boardState.append(getBlackPawnsResult()).append("\n");
                    if(i == 6) boardState.append(getWhitePawnsResult()).append("\n");
                    else boardState.append(blankRow).append("\n");
                });
        System.out.println(boardState);
    }

    private String getWhitePawnsResult() {
        return pawns.stream()
                .filter(pawn -> !pawn.isBlack())
                .map(pawn -> "p")
                .collect(Collectors.joining());
    }

    private String getBlackPawnsResult() {
        return pawns.stream()
                .filter(Pawn::isBlack)
                .map(pawn -> "P")
                .collect(Collectors.joining());
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
