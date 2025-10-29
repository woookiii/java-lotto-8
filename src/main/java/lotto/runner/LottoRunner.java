package lotto.runner;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.ui.CostUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRunner {
    private final CostUI costUI = new CostUI();


    public void run() {
        costUI.guideCostInput();
        final Integer cost = costUI.repeatGetCostInputUntilRight();
        final Integer lottoCount = costToLottoCount(cost);
        showLottoCount(lottoCount);
        List<Lotto> lottos = new ArrayList<>();
        purchase(lottoCount, lottos);


    }

    private void purchase(Integer lottoCount, List<Lotto> lottos) {
        for (int lottoIndex = 0; lottoIndex < lottoCount; lottoIndex++) {
            List<Integer> numbers = makeNumbers();
            Lotto lotto = new Lotto(numbers);
            showNumbers(lotto);
            lottos.add(lotto);
        }
    }

    private void showNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    private List<Integer> makeNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private void showLottoCount(Integer lottoCount) {
        System.out.format("%n%d개를 구매했습니다.%n", lottoCount);
    }

    private Integer costToLottoCount(Integer cost) {
        return cost / 1000;
    }
}
