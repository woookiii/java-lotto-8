package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.enumeration.LottoNumber;
import lotto.view.LottoView;

import java.util.Collections;
import java.util.List;

public class LottoService {
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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public Integer costToLottoCount(Integer cost, LottoNumber price) {
        return cost / price.getValue();
    }

}
