package domain;

public enum Piece {
    KING("K"),
    QUEEN("Q"),
    ROOK("R"),
    BISHOP("B"),
    KNIGHT("N"),
    PAWN("");

    private final String shortName;

    Piece(String shortName) {
        this.shortName = shortName;
    }

    public static Piece byShortName(String shortName) {
        for (Piece piece : Piece.values()) {
            if (piece.shortName.equals(shortName)) {
                return piece;
            }
        }
        throw new IllegalArgumentException("Incorrect short name '" + shortName + "'");
    }

}
