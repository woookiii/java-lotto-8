package lotto.enumeration;

public enum ResultMessage {

    PURCHASED_LOTTO_COUNT("%n%s개를 구매했습니다.%n"),
    HIT_STATISTIC_HEADER("\n당첨 통계\n---"),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    RATE_OF_RETURN("총 수익률은 %s%%입니다.%n"),
    HitTimesWithPrizeWhenBonus("%d개 일치, 보너스 볼 일치 (%s원) - %s개%n"),
    HitTimesWithPrize("%d개 일치 (%s원) - %s개%n");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
