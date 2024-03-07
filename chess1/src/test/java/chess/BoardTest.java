package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board board;

    @BeforeEach
    @DisplayName("초기 체스 판을 생성")
    void create(){
        board = new Board();
    }

    @Test
    @DisplayName("기물이 3개 추가되면 체스 판의 크기는 3이다.")
    void increaseBoardSizeByAddingPiece() {
        final Board onePiece = board.add(Piece.createWhitePawn());
        final Board twoPiece = onePiece.add(Piece.createBlackPawn());
        final Board threePiece = twoPiece.add(Piece.createBlackPawn());

        assertThat(threePiece.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("체스 판의 목록을 얻어와 추가한 기물을 찾는다.")
    void findPieceByPosition() {
        Piece blackPawn = Piece.createBlackPawn();
        final Board onePiece = board.add(blackPawn);

        final Piece found = onePiece.findPawn(0);

        assertThat(found).isEqualTo(blackPawn);
    }

    @Test
    @DisplayName("체스 판을 초기화 하면 흰색 폰 8개와 검은색 폰8개가 생성되어 총 16개가 된다")
    void initializedBoardHas16Pawn() {
        final Board initBoard = board.initialize();

        assertThat(initBoard.size()).isEqualTo(16);
    }

    @Test
    @DisplayName("초기화 한 체스 판의 상태를 확인한다.")
    void checkStateOfInitializedBoard() {
        final Board initBoard = board.initialize();
        initBoard.print();
    }
}
