package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.enumeration.*;

import java.util.Locale;

public class LottoView {

    public void showNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void showLottoCount(Integer lottoCount, ResultMessage resultMessage) {
        String separatedLottoCount = separateNumberForRegion(lottoCount, DecimalPlace.ZERO);
        System.out.format(resultMessage.getMessage(), separatedLottoCount);
    }

    public void guideInput(GuideMessage guideMessage) {
        System.out.println(guideMessage.getMessage());
    }

    public void showResult(Statistic statistic, Double rateOfReturn, ResultMessage resultMessage) {
        System.out.println(resultMessage.getMessage());
        showHits(statistic);
        showRateOfReturn(rateOfReturn, ResultMessage.RATE_OF_RETURN);
    }

    private void showRateOfReturn(double rateOfReturn, ResultMessage resultMessage) {
        if(rateOfReturn == (long)rateOfReturn){
            final String seperatedRate = separateNumberForRegion(rateOfReturn, DecimalPlace.ZERO);
            System.out.format(resultMessage.getMessage(), seperatedRate);
            return;
        }
        final String seperatedRate = separateNumberForRegion(rateOfReturn, DecimalPlace.ONE);
        System.out.format(resultMessage.getMessage(), seperatedRate);
    }

    private void showHits(Statistic statistic) {
        showHitTimesWithPrize(Prize.HIT_THREE, statistic.getHitThree());
        showHitTimesWithPrize(Prize.HIT_FOUR, statistic.getHitFour());
        showHitTimesWithPrize(Prize.HIT_FIVE_WITHOUT_BONUS, statistic.getHitFiveWithoutBonus());
        showHitTimesWithPrizeWhenBonus(Prize.HIT_FIVE_WITH_BONUS, statistic.getHitFiveWithBonus());
        showHitTimesWithPrize(Prize.HIT_SIX, statistic.getHitSix());
    }

    private void showHitTimesWithPrizeWhenBonus(Prize prize, Integer hitTimes) {
        final String money = separateNumberForRegion(prize.getMoney(), DecimalPlace.ZERO);
        final String times = separateNumberForRegion(hitTimes, DecimalPlace.ZERO);
        System.out.format(ResultMessage.HitTimesWithPrizeWhenBonus.getMessage(), prize.getHits() , money, times);
    }

    private void showHitTimesWithPrize(Prize prize, Integer hitTimes) {
        final String money = separateNumberForRegion(prize.getMoney(), DecimalPlace.ZERO);
        final String times = separateNumberForRegion(hitTimes, DecimalPlace.ZERO);
        System.out.format(ResultMessage.HitTimesWithPrize.getMessage(), prize.getHits() , money, times);
    }

    private String separateNumberForRegion(double number, DecimalPlace decimalPlace) {
        StringBuilder form = new StringBuilder();
        form.append(FormatSymbol.PERCENT.getSymbol())
                .append(FormatSymbol.COMMA.getSymbol())
                .append(FormatSymbol.PERIOD.getSymbol())
                .append(decimalPlace.getDecimalPlace())
                .append(FormatSymbol.FLOAT.getSymbol());
        return String.format(Locale.KOREA, form.toString(), number);
    }
}
