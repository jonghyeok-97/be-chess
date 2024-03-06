package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board initBoard;
    private Pawn white;
    private Pawn black;

    @BeforeEach
    @DisplayName("초기 체스 판을 생성")
    void create(){
        initBoard = new Board();
        white = Pawn.createWhitePawn();
        black = Pawn.createBlackPawn();
    }

    @Test
    @DisplayName("폰이 추가될 때마다 체스 판의 크기는 1만큼 증가한다")
    void increaseBoardSizeByAddingPawn() {
        final Board onePiece = initBoard.add(white);
        final Board twoPiece = onePiece.add(black);
        final Board threePiece = twoPiece.add(black);

        assertThat(threePiece.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("체스 판의 목록을 얻어와 추가한 폰을 찾는다.")
    void findPawnByPosition() {
        final Board onePiece = initBoard.add(black);
        final Board twoPiece = onePiece.add(white);

        final Pawn found = onePiece.findPawn(0);

        assertThat(found).isEqualTo(black);
    }
}
