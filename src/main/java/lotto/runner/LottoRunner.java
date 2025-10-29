package lotto.runner;

import lotto.Lotto;
import lotto.enumeration.GuideMessage;
import lotto.enumeration.LottoNumber;
import lotto.service.LottoService;
import lotto.ui.CostUI;
import lotto.ui.LottoUI;

import java.util.ArrayList;
import java.util.List;

public class LottoRunner {

    private final CostUI costUI = new CostUI();
    private final LottoUI lottoUI = new LottoUI();
    private final LottoService lottoService = new LottoService();


    public void run() {
        lottoUI.guideInput(GuideMessage.COST);
        final Integer cost = costUI.repeatGetCostInputUntilRight();
        final Integer lottoCount = lottoService.costToLottoCount(cost, LottoNumber.PRICE);
        final List<Lotto> lottos = new ArrayList<>();
        lottoService.purchase(lottoCount, lottos);
        lottoUI.guideInput(GuideMessage.WINNING_NUMBERS);
        final List<Integer> winningNumbers = lottoUI.repeatGetWinningNumbersInputUntilRight();

    }




}
