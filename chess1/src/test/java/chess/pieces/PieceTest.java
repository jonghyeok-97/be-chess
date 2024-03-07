package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private static Stream<Piece> provideWhitePieces() {
        return Stream.of(
                Piece.createWhitePawn(),
                Piece.createWhiteKnight(),
                Piece.createWhiteBishop(),
                Piece.createWhiteQueen(),
                Piece.createWhiteKing(),
                Piece.createWhiteRook()
        );
    }

    private static Stream<Piece> provideBlackPieces() {
        return Stream.of(
                Piece.createBlackPawn(),
                Piece.createBlackKnight(),
                Piece.createBlackBishop(),
                Piece.createBlackQueen(),
                Piece.createBlackKing(),
                Piece.createBlackRook()
        );
    }

    @ParameterizedTest
    @DisplayName("검은색 기물들의 색깔은 검은색이다.")
    @MethodSource("provideBlackPieces")
    void compareBlackPiecesAndBlack(final Piece piece) {
        assertTrue(piece.isBlack());
    }

    @ParameterizedTest
    @DisplayName("흰색 기물들의 색깔은 흰색이다")
    @MethodSource("provideWhitePieces")
    void compareWhitePiecesAndWhite(final Piece piece) {
        assertFalse(piece.isBlack());
    }

    @Test
    @DisplayName("흰색 기물들은 값 객체다")
    void validateWhitePiecesIsValueObject() {
        List<Piece> whitePieces = provideWhitePieces().toList();
        List<Piece> testWhitePieces = provideWhitePieces().toList();

        assertEquals(whitePieces, testWhitePieces);
    }

    @Test
    @DisplayName("검은색 기물들은 값 객체다")
    void validateBlackPiecesIsValueObject() {
        List<Piece> blackPieces = provideWhitePieces().toList();
        List<Piece> testBlackPieces = provideWhitePieces().toList();

        assertEquals(blackPieces, testBlackPieces);
    }
}