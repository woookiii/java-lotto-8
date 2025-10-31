package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.enumeration.DecimalPlace;
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
        showRateOfReturn(rateOfReturn);
    }

    private void showRateOfReturn(double rateOfReturn) {
        if(rateOfReturn == (long)rateOfReturn){
            final String seperatedRate = separateNumber(rateOfReturn, DecimalPlace.ZERO);
            System.out.format("총 수익률은 %s%%입니다.", seperatedRate);
            return;
        }
        final String seperatedRate = separateNumber(rateOfReturn, DecimalPlace.ONE);
        System.out.format("총 수익률은 %s%%입니다.", seperatedRate);
    }

    private void showHits(Statistic statistic) {
        showHitTimesWithPrize(Prize.HIT_THREE, statistic.getHitThree());
        showHitTimesWithPrize(Prize.HIT_FOUR, statistic.getHitFour());
        showHitTimesWithPrize(Prize.HIT_FIVE_WITHOUT_BONUS, statistic.getHitFiveWithoutBonus());
        showHitTimesWithPrizeWhenBonus(Prize.HIT_FIVE_WITH_BONUS, statistic.getHitFiveWithBonus());
        showHitTimesWithPrize(Prize.HIT_SIX, statistic.getHitSix());
    }

    private void showHitTimesWithPrizeWhenBonus(Prize prize, Integer hitTimes) {
        final String money = separateNumber(prize.getPrize(), DecimalPlace.ZERO);
        final String times = separateNumber(hitTimes, DecimalPlace.ZERO);
        System.out.format("%d개 일치, 보너스 볼 일치 (%s원) - %s개", prize.getHits() , money, times);
    }

    private void showHitTimesWithPrize(Prize prize, Integer hitTimes) {
        final String money = separateNumber(prize.getPrize(), DecimalPlace.ZERO);
        final String times = separateNumber(hitTimes, DecimalPlace.ZERO);
        System.out.format("%d개 일치 (%s원) - %s개", prize.getHits() , money, times);
    }

    private String separateNumber(double number, DecimalPlace decimalPlace) {
        StringBuilder form = new StringBuilder();
        form.append("%,.")
                .append(decimalPlace.getDecimalPlace())
                .append("f");
        return String.format(Locale.KOREA.getCountry(), form, number)
                .replace(",", Delimiter.COMMA.getDelimiter())
                .replace(".", Delimiter.PERIOD.getDelimiter());
    }
}
