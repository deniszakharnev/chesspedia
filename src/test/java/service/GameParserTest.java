package service;

import antlr.AntlrAlgebraicGameParser;
import domain.Color;
import domain.Move;
import domain.Piece;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameParserTest {

    private AntlrAlgebraicGameParser gameParser = new AntlrAlgebraicGameParser();

    @Test
    public void testTwoMinutesGame() throws IOException {
        File file = ResourceUtils.getFile("classpath:two_minutes_game.txt");
        assertThat(file.exists(), is(TRUE));

        List<Move> moves = gameParser.parse(file);
        assertThat(moves.size(), is(20));

        Move firstMove = moves.get(0);
        checkMove(firstMove, Color.WHITE, Piece.PAWN, "c2", "c4", false);

        Move secondMove = moves.get(1);
        checkMove(secondMove, Color.BLACK, Piece.PAWN, "e7", "e5", false);

        Move forthMove = moves.get(3);
        checkMove(forthMove, Color.BLACK, Piece.KNIGHT, "b8", "c6", false);

        Move fifteenthMove = moves.get(14);
        checkMove(fifteenthMove, Color.WHITE, Piece.BISHOP, "g2", "f3", true);
    }

    private void checkMove(Move moveToCheck, Color pieceColor, Piece piece, String moveFrom, String moveTo, boolean isCapture) {
        assertThat(moveToCheck.getColor(), is(pieceColor));
        assertThat(moveToCheck.getPiece(), is(piece));
        assertThat(moveToCheck.getMoveFrom(), is(moveFrom));
        assertThat(moveToCheck.getMoveTo(), is(moveTo));
        assertThat(moveToCheck.isCapture(), is(isCapture));
    }
}
