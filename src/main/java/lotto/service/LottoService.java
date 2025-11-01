package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.enumeration.LottoNumber;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int PERCENT = 100;

    private final LottoView lottoView = new LottoView();

    public void purchase(Integer lottoCount, List<Lotto> lottos) {
        lottoView.showLottoCount(lottoCount);
        for (int lottoIndex = 0; lottoIndex < lottoCount; lottoIndex++) {
            List<Integer> numbers = makeNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoView.showNumbers(lotto);
            lottos.add(lotto);
        }
    }

    private List<Integer> makeNumbers() {
        List<Integer> unmodifiableNumbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.START_INCLUSIVE.getValue(),
                LottoNumber.END_INCLUSIVE.getValue(),
                LottoNumber.NUMBERS_SIZE.getValue()
        );
        List<Integer> numbers = new ArrayList<>(unmodifiableNumbers);
        Collections.sort(numbers);
        return numbers;
    }

    public Integer costToLottoCount(Long cost, LottoNumber price) {
        return (int) (cost / price.getValue());
    }

    public Statistic makeStatistic(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        final Statistic statistic = new Statistic();
        for (Lotto lotto : lottos) {
            checkLotto(winningNumbers, bonusNumber, lotto, statistic);
        }
        return statistic;
    }

    private void checkLotto(List<Integer> winningNumbers, Integer bonusNumber, Lotto lotto, Statistic statistic) {
        Long winCount = matchLottoWithWinningNumbers(winningNumbers, lotto);
        Boolean bonus = didLottoHitBonusNumber(bonusNumber, lotto);
        if(winCount < 3) {
            return;
        }
        statistic.add(winCount, bonus);
    }

    private long matchLottoWithWinningNumbers(List<Integer> winningNumbers, Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Boolean didLottoHitBonusNumber(Integer bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Double calculateRateOfReturn(Long profit, Long cost) {
        Double rateOfReturn = (double) profit * PERCENT / cost;
        return rateOfReturn;
    }

}
