package domain;

import lombok.Data;

@Data
public class Move {
    private Color color;
    private Piece piece;
    private String moveFrom;
    private String moveTo;
    private boolean capture;
}
