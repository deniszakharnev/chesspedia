package antlr;

import domain.Color;
import domain.Move;
import domain.Piece;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import static com.google.common.collect.Lists.newArrayList;

@Slf4j
public class MyChessGameListener implements ChessGameListener {

    @Override
    public void enterPair_move(ChessGameParser.Pair_moveContext ctx) {

    }

    @Override
    public void exitPair_move(ChessGameParser.Pair_moveContext ctx) {
        ChessGameParser.MoveContext whiteMove = ctx.move(0);
        Move move1 = getMove(whiteMove, Color.WHITE);

        ChessGameParser.MoveContext blackMove = ctx.move(1);
        Move move2 = getMove(blackMove, Color.BLACK);

        ctx.movePair = new Pair<>(move1, move2);
    }

    private Move getMove(ChessGameParser.MoveContext moveCtx, Color color) {
        Move move = new Move();
        move.setColor(color);
        if (moveCtx.Castling() == null) {
            if (moveCtx.Piece() != null) {
                move.setPiece(Piece.byShortName(moveCtx.Piece().getText()));
            } else {
                move.setPiece(Piece.PAWN);
            }
            move.setMoveFrom(moveCtx.Square(0).getText());
            move.setMoveTo(moveCtx.Square(1).getText());

            if ("x".equalsIgnoreCase(moveCtx.MoveType().getText())) {
                move.setCapture(true);
            }

            if (moveCtx.Check() != null) {
                move.setCheck(true);
            }

            if (moveCtx.Mate() != null) {
                move.setMate(true);
            }
        }
        return move;
    }

    @Override
    public void enterParseGame(ChessGameParser.ParseGameContext ctx) {
        ctx.moves = newArrayList();
    }

    @Override
    public void exitParseGame(ChessGameParser.ParseGameContext ctx) {
        ctx.pair_move().stream().map(x -> x.movePair).forEach(x ->
                ctx.moves.addAll(newArrayList(x.a, x.b))
        );
    }

    @Override
    public void enterMove(ChessGameParser.MoveContext ctx) {

    }

    @Override
    public void exitMove(ChessGameParser.MoveContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
