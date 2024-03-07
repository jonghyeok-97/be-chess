package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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

    // 검은색 룩,나이트,비숍,퀸,킹,~~ 룩 들이 담긴 랭크
    public Rank createRank8() {
        return new Rank(getPiecesOfRank8());
    }

    // 검은색 폰이 담긴 랭크
    public Rank createRank7() {
        final Function<Integer, Piece> blackPawns = i -> Piece.createBlackPawn();
        return new Rank(createPawnsFrom(blackPawns));
    }

    // 흰색 룩,나이트,비숍,퀸,~~~나이트, 룩이 담긴 랭크
    public Rank createRank1() {
        return new Rank(getPiecesOfRank1());
    }

    // 흰색 폰들이 담긴 랭크
    public Rank createRank2() {
        final Function<Integer, Piece> whitePawns = i -> Piece.createWhitePawn();
        return new Rank(createPawnsFrom(whitePawns));
    }

    public Rank createBlankRank() {
        final List<Piece> empties = IntStream.rangeClosed(1, 8)
                .mapToObj(i -> Piece.createEmpty())
                .collect(Collectors.toList());
        return new Rank(empties);
    }

    private List<Piece> getPiecesOfRank8() {
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

    private List<Piece> getPiecesOfRank1() {
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

    private List<Piece> createPawnsFrom(Function<Integer, Piece> pawnsByColor) {
        return IntStream.rangeClosed(1, 8)
                .mapToObj(pawnsByColor::apply)
                .collect(Collectors.toList());
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
