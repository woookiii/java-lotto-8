package lotto.enumeration;

public enum LottoNumber {

    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    NUMBERS_SIZE(6),
    PRICE(1000);

    private final Integer value;

    LottoNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
