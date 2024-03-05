package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board initBoard;

    @BeforeEach
    @DisplayName("초기 체스 판을 생성")
    void create(){
        initBoard = new Board();
    }

    @Test
    @DisplayName("폰이 추가될 때마다 체스 판의 크기는 1만큼 증가한다")
    void increaseBoardSizeByAddingPawn() {
        final Pawn white = Pawn.createPawn(Color.WHITE);
        final Pawn black = Pawn.createPawn(Color.BLACK);

        final Board onePiece = initBoard.add(white);
        final Board twoPiece = onePiece.add(black);
        final Board threePiece = twoPiece.add(black);

        assertThat(threePiece.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("체스 판의 위치를 지정하면 위치에 해당하는 폰을 찾는다.")
    void findPawnByPosition() {
        final Pawn black = Pawn.createPawn(Color.BLACK);

        final Board onePiece = initBoard.add(black);
        final Pawn found = onePiece.findPawn(0);

        assertThat(found).isEqualTo(black);
    }
}
