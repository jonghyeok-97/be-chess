package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("폰 색깔은 흰색과 검정색이다.")
    void createPawn() {
        Pawn white = Pawn.createWhitePawn();
        Pawn black = Pawn.createBlackPawn();

        assertThat(white).extracting("color").isEqualTo(Color.WHITE);
        assertThat(black).extracting("color").isEqualTo(Color.BLACK);
    }
}