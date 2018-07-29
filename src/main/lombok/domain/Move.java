package domain;

import lombok.Value;

@Value
public class Move {
    private Color color;
    private Piece piece;
    private String movesTo;
}
