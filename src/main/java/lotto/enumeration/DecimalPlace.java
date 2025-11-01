package lotto.enumeration;

public enum DecimalPlace {

    ZERO(0),
    ONE(1);

    private final Integer decimalPlace;

    DecimalPlace(Integer decimalPlace) {
        this.decimalPlace = decimalPlace;
    }

    public Integer getDecimalPlace() {
        return decimalPlace;
    }
}
