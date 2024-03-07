package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    @DisplayName("초기 체스 판을 생성")
    void create() {
        board = new Board();
    }

//    @Test
//    @DisplayName("기물이 3개 추가되면 체스 판의 크기는 3이다.")
//    void increaseBoardSizeByAddingPiece() {
//        final Board onePiece = board.add(Piece.createWhitePawn());
//        final Board twoPiece = onePiece.add(Piece.createBlackPawn());
//        final Board threePiece = twoPiece.add(Piece.createBlackPawn());
//
//        assertEquals(3, threePiece.size());
//    }
//
//    @Test
//    @DisplayName("체스 판의 목록을 얻어와 추가한 기물을 찾는다.")
//    void findPieceByPosition() {
//        Piece blackPawn = Piece.createBlackPawn();
//        final Board onePiece = board.add(blackPawn);
//
//        final Piece found = onePiece.findPawn(0);
//
//        assertEquals(found, blackPawn);
//    }

    @Test
    @DisplayName("체스 판을 초기화 하면 Chessmen 이 되어 총 32개가 된다")
    void initializedBoardHas16Pawn() {
        final Board initBoard = board.initialize();
        assertEquals(initBoard.size(), 32);
    }

    @Test
    @DisplayName("초기화 한 체스 판의 상태를 확인한다.")
    void checkStateOfInitializedBoard() {
        final Board initBoard = board.initialize();
        System.out.println(initBoard.print());
    }

    @Test
    @DisplayName("초기화 한 체스판의 크기와 상태를 출력한다.")
    void createExam() {
        final Board initBoard = board.initialize();
        assertEquals(32, initBoard.size());

        final String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                initBoard.print());
    }
}
