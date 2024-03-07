package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Rank {
    private final List<Piece> pieces;

    public Rank() {
        this.pieces = new ArrayList<>();
    }

    private Rank(final List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Rank createRank8() {
        return new Rank(getRank8());
    }

    public Rank createRank7() {
        final List<Piece> blackPawns = IntStream.rangeClosed(1, 8)
                .mapToObj(i -> Piece.createBlackPawn())
                .collect(Collectors.toList());
        return new Rank(blackPawns);
    }

    public Rank createRank1() {
        return new Rank(getRank1());
    }

    public Rank createRank2() {
        final List<Piece> whitePawns = IntStream.rangeClosed(1, 8)
                .mapToObj(i -> Piece.createWhitePawn())
                .collect(Collectors.toList());
        return new Rank(whitePawns);
    }

    public Rank createBlankRank() {
        final List<Piece> empties = IntStream.rangeClosed(1, 8)
                .mapToObj(i -> Piece.createEmpty())
                .collect(Collectors.toList());
        return new Rank(empties);
    }

    private List<Piece> getRank8() {
        return Stream.of(
                Piece.createBlackRook(),
                Piece.createBlackKnight(),
                Piece.createBlackBishop(),
                Piece.createBlackQueen(),
                Piece.createBlackKing(),
                Piece.createBlackBishop(),
                Piece.createBlackKnight(),
                Piece.createBlackRook()
        ).collect(Collectors.toList());
    }

    private List<Piece> getRank1() {
        return Stream.of(
                Piece.createWhiteRook(),
                Piece.createWhiteKnight(),
                Piece.createWhiteBishop(),
                Piece.createWhiteQueen(),
                Piece.createWhiteKing(),
                Piece.createWhiteBishop(),
                Piece.createWhiteKnight(),
                Piece.createWhiteRook()
        ).collect(Collectors.toList());
    }

    public String getSymbols() {
        return pieces.stream()
                .map(piece -> {
                    if(piece.isWhite()) return piece.getSymbol().toLowerCase();
                    else return piece.getSymbol();
                }).collect(Collectors.joining());
    }

    public int countPiece() {
        return (int) pieces.stream()
                .filter(piece -> piece.isBlack() || piece.isWhite())
                .count();

    }
}
