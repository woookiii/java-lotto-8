package lotto.enumeration;

public enum FormatSymbol {

    COMMA(","),
    PERIOD("."),
    PERCENT("%"),
    FLOAT("f");

    private final String symbol;

    FormatSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
