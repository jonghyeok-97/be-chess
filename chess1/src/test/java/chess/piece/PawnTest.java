package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PawnTest {

    @ParameterizedTest
    @DisplayName("폰의 색깔은 흰색과 검정색이어야 한다.")
    @EnumSource(value = Color.class, names = {"WHITE", "BLACK"})
    void create(Color color) {
        assertThatCode(() -> new Pawn(color))
                .doesNotThrowAnyException();
    }
}