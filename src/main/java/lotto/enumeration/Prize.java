package lotto.enumeration;

public enum Prize {
    HIT_THREE(3L, 5_000),
    HIT_FOUR(4L, 50_000),
    HIT_FIVE_WITHOUT_BONUS(5L, 1_500_000),
    HIT_FIVE_WITH_BONUS(5L, 30_000_000),
    HIT_SIX(6L, 2_000_000_000);

    private final Long hits;
    private final Integer prize;


    Prize(Long hits, Integer prize) {
        this.hits = hits;
        this.prize = prize;
    }

    public Long getHits() {
        return hits;
    }

    public Integer getPrize() {
        return prize;
    }
}
