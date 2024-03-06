package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
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
        boardState.append(blankRow).append("\n")
                .append(getBlackPawnsResult()).append("\n")
                .append(blankRow).append("\n")
                .append(blankRow).append("\n")
                .append(blankRow).append("\n")
                .append(blankRow).append("\n")
                .append(getWhitePawnsResult()).append("\n")
                .append(blankRow).append("\n");
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
