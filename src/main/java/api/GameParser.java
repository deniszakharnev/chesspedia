package api;

import domain.Move;

import java.io.File;
import java.util.List;

public interface GameParser {
    List<Move> parse(File file);
}
