package antlr;

import api.GameParser;
import domain.Move;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AntlrAlgebraicGameParser implements GameParser {
    @Override
    public List<Move> parse(File file) {
        try {
            Lexer lexer = new ChessGameLexer(CharStreams.fromFileName(file.getAbsolutePath()));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ChessGameParser parser = new ChessGameParser(tokens);
            ChessGameParser.ParseGameContext parseGameContext = parser.parseGame();

            MyChessGameListener listener = new MyChessGameListener();
            ParseTreeWalker.DEFAULT.walk(listener, parseGameContext);

            return parseGameContext.moves;
        } catch (IOException ioe) {
            throw new RuntimeException("Error while parsing game records", ioe);
        }
    }
}
