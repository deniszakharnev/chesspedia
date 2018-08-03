package domain;

public enum Color {
    WHITE("W"),
    BLACK("B");

    private String shortName;

    Color(String shortName) {
        this.shortName = shortName;
    }

    static Color byShortName(String shortName) {
        for (Color piece : Color.values()) {
            if (piece.shortName.equals(shortName)) {
                return piece;
            }
        }
        throw new IllegalArgumentException("Incorrect color name '" + shortName + "'");
    }

}
