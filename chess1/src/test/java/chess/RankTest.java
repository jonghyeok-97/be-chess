package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {
    private Rank rank;

    @BeforeEach
    void setUP() {
        rank = new Rank();
    }

    @Test
    @DisplayName("랭크8에 해당하는 검은색 기물들의 심볼을 비교한다")
    void createBlackPiecesOfRank8() {
        final Rank rank8 = rank.createRank8();
        final String symbols = rank8.getSymbols();

        assertEquals(symbols, "RNBQKBNR");
    }

    @Test
    @DisplayName("랭크7에 해당하는 검은색 폰들의 심볼을 비교한다")
    void createBlackPawnsOfRank8() {
        final Rank rank7 = rank.createRank7();
        final String symbols = rank7.getSymbols();

        assertEquals(symbols, "PPPPPPPP");
    }

    @Test
    @DisplayName("랭크3~6에 해당하는 빈 공간의 심볼을 비교한다")
    void createEmptiesFromRank3toRank6() {
        final Rank empties = rank.createBlankRank();
        final String symbols = empties.getSymbols();

        assertEquals(symbols, "........");
    }

    @Test
    @DisplayName("랭크2에 해당하는 흰색 폰들의 심볼을 비교한다")
    void createWhitePawnsOfRank2() {
        final Rank rank2 = rank.createRank2();
        final String symbols = rank2.getSymbols();

        assertEquals(symbols, "pppppppp");
    }

    @Test
    @DisplayName("랭크1에 해당하는 흰색 기물들의 심볼을 비교한다")
    void createWhitePiecesOfRank1() {
        final Rank rank1 = rank.createRank1();
        final String symbols = rank1.getSymbols();

        assertEquals(symbols, "rnbqkbnr");
    }
}
