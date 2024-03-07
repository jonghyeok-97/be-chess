package chess;

import chess.pieces.Color;
import chess.pieces.ColorException;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Utils.StringUtils.appendNewLine;

public class Board {
    private final List<Piece> pieces;

    Board() {
        this.pieces = new ArrayList<>();
    }

    private Board(final List<Piece> pieces) {
        this.pieces = pieces;
    }

    Board initialize() {
        final List<Piece> pieces = Stream.concat(
                IntStream.rangeClosed(1, 8).mapToObj(i -> Piece.createWhitePawn()),
                IntStream.rangeClosed(1, 8).mapToObj(i -> Piece.createBlackPawn())
        ).toList();
        return new Board(pieces);
    }

    void print() {
        final String blankRow = ".".repeat(8);
        final StringBuilder boardState = new StringBuilder();
        IntStream.rangeClosed(1, 8)
                .forEach(i -> {
                    if(i == 2) boardState.append(appendNewLine(getBlackPawnsResult()));
                    if(i == 6) boardState.append(appendNewLine(getWhitePawnsResult()));
                    else boardState.append(appendNewLine(blankRow));
                });
        System.out.println(boardState);
    }

    private String getWhitePawnsResult() {
        return pieces.stream()
                .filter(piece -> !piece.isBlack())
                .map(piece -> "p")
                .collect(Collectors.joining());
    }

    private String getBlackPawnsResult() {
        return pieces.stream()
                .filter(Piece::isBlack)
                .map(piece -> "P")
                .collect(Collectors.joining());
    }


    Board add(final Piece piece) {
        final List<Piece> adding = new ArrayList<>(pieces);
        adding.add(piece);
        return new Board(adding);
    }

    int size() {
        return pieces.size();
    }

    Piece findPawn(final int position) {
        return pieces.get(position);
    }
}
