package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @ParameterizedTest
    @DisplayName("폰 색깔은 흰색과 검정색이어야 한다.")
    @EnumSource(value = Color.class, names = {"WHITE", "BLACK"})
    void createPawn(Color color) {
        assertThatCode(() -> Pawn.createPawn(color))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("폰 색깔의 기본값은 흰색이다")
    void create_기본생성자() {
        final Pawn defaultPawn = Pawn.createDefaultPawn();
        assertEquals(Color.WHITE, defaultPawn.getColor());
    }
}