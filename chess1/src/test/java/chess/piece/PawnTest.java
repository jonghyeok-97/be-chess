package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다.")
    void create() {
        Pawn whitePawn = new Pawn(Color.WHITE);
        assertThat(whitePawn.getColor()).isEqualTo(Color.WHITE);

        Pawn blackPawn = new Pawn(Color.BLACK);
        assertThat(blackPawn.getColor()).isEqualTo(Color.BLACK);

//        assertThatThrownBy(() -> new Pawn(null))
//                .isInstanceOf(IllegalArgumentException.class);
    }
}