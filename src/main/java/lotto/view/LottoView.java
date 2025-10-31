package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.enumeration.Delimiter;
import lotto.enumeration.GuideMessage;
import lotto.enumeration.Prize;

import java.util.Locale;

public class LottoView {

    public void showNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void showLottoCount(Integer lottoCount) {
        System.out.format("%n%d개를 구매했습니다.%n", lottoCount);
    }

    public void guideInput(GuideMessage guideMessage) {
        System.out.println(guideMessage.getMessage());
    }

    public void showResult(Statistic statistic, Double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        showHits(statistic);
    }

    private void showHits(Statistic statistic) {
        showHitTimesWithPrize(Prize.HIT_THREE, statistic.getHitThree());
        showHitTimesWithPrize(Prize.HIT_FOUR, statistic.getHitFour());
        showHitTimesWithPrize(Prize.HIT_FIVE_WITHOUT_BONUS, statistic.getHitFiveWithoutBonus());
        showHitTimesWithPrizeWhenBonus(Prize.HIT_FIVE_WITH_BONUS, statistic.getHitFiveWithBonus());
        showHitTimesWithPrize(Prize.HIT_SIX, statistic.getHitSix());
    }

    private void showHitTimesWithPrizeWhenBonus(Prize prize, Integer hitTimes) {
        String money = separateNumber(prize.getPrize());
        String times = separateNumber(hitTimes);
        System.out.format("%d개 일치, 보너스 볼 일치 (%s원) - %s개", prize.getHits() , money, times);
    }

    private void showHitTimesWithPrize(Prize prize, Integer hitTimes) {
        String money = separateNumber(prize.getPrize());
        String times = separateNumber(hitTimes);
        System.out.format("%d개 일치 (%s원) - %s개", prize.getHits() , money, times);
    }

    private String separateNumber(Integer number) {
        return String.format(Locale.KOREA.getCountry(), "%,d", number)
                .replace(",", Delimiter.COMMA.getDelimiter());
    }
}
