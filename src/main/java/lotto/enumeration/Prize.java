package lotto.enumeration;

public enum Prize {

    HIT_THREE(3L, 5000),
    HIT_FOUR(4L, 50000),
    HIT_FIVE_WITHOUT_BONUS(5L, 1500000),
    HIT_FIVE_WITH_BONUS(5L, 30000000),
    HIT_SIX(6L, 2000000000);

    private final Long hits;
    private final Integer money;


    Prize(Long hits, Integer money) {
        this.hits = hits;
        this.money = money;
    }

    public Long getHits() {
        return hits;
    }

    public Integer getMoney() {
        return money;
    }
}
