package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("흰색 폰의 색깔은 흰색이다.")
    void createWhitePawn() {
        Pawn white = Pawn.createWhitePawn();

        assertThat(white.isSameColor(Color.WHITE)).isTrue();
    }

    @Test
    @DisplayName("검은색 폰의 색깔은 검은색이다.")
    void createBlackPawn3() {
        Pawn black = Pawn.createBlackPawn();

        assertThat(black.isSameColor(Color.BLACK)).isTrue();
    }
}