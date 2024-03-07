package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Utils.StringUtils.appendNewLine;

public class Board {
    private final List<Rank> ranks;

    Board() {
        this.ranks = new ArrayList<>();
    }

    private Board(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    Board initialize() {
        final Rank rank = new Rank();
        final List<Rank> chessmen = Stream.of(rank.createRank8(),
                rank.createRank7(),
                rank.createBlankRank(),
                rank.createBlankRank(),
                rank.createBlankRank(),
                rank.createBlankRank(),
                rank.createRank2(),
                rank.createRank1()).collect(Collectors.toList());
        return new Board(chessmen);
    }

    String print() {
        return ranks.stream()
                .map(rank -> rank.getSymbols())
                .map(symbols -> appendNewLine(symbols))
                .collect(Collectors.joining());
    }


    Board add(final Piece piece) {
//        final List<Piece> adding = new ArrayList<>(pieces);
//        adding.add(piece);
//        return new Board(adding);
        return null;
    }

    int size() {
        return ranks.stream()
                .mapToInt(rank -> rank.countPiece())
                .sum();
    }

    Piece findPawn(final int position) {
        // return pieces.get(position);
        return null;
    }
}
