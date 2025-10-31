package lotto.enumeration;

public enum Delimiter {
    COMMA(","),
    PERIOD(".");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }


    public String getDelimiter() {
        return delimiter;
    }
}
