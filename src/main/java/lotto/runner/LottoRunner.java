package lotto.runner;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.ui.CostUI;

import java.util.ArrayList;
import java.util.List;

public class LottoRunner {
    private final CostUI costUI = new CostUI();
    private final LottoService lottoService = new LottoService();


    public void run() {
        costUI.guideCostInput();
        final Integer cost = costUI.repeatGetCostInputUntilRight();
        final Integer lottoCount = lottoService.costToLottoCount(cost);
        final List<Lotto> lottos = new ArrayList<>();
        lottoService.purchase(lottoCount, lottos);
        guideWinningNumbersInput();


    }

    private void guideWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

}
