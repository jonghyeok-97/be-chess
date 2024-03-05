package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PawnTest {

    @ParameterizedTest
    @DisplayName("폰의 색깔은 흰색과 검정색이어야 한다.")
    @EnumSource(value = Color.class, names = {"WHITE", "BLACK"})
    void createPawnValidColor(Color color) {
        assertThatCode(() -> new Pawn(color))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("폰의 색깔이 없으면 폰은 생성되지 않는다")
    void createPawnNoColor() {
        assertThatThrownBy(() -> new Pawn(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}