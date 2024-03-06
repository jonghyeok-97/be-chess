package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board board;

    @BeforeEach
    @DisplayName("초기 체스 판을 생성")
    void create(){
        board = new Board();
    }

    @Test
    @DisplayName("폰이 3개 추가되면 체스 판의 크기는 3이다.")
    void increaseBoardSizeByAddingPawn() {
        final Board onePiece = board.add(Pawn.createWhitePawn());
        final Board twoPiece = onePiece.add(Pawn.createBlackPawn());
        final Board threePiece = twoPiece.add(Pawn.createBlackPawn());

        assertThat(threePiece.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("체스 판의 목록을 얻어와 추가한 폰을 찾는다.")
    void findPawnByPosition() {
        Pawn black = Pawn.createBlackPawn();
        final Board onePiece = board.add(black);

        final Pawn found = onePiece.findPawn(0);

        assertThat(found).isEqualTo(black);
    }


}