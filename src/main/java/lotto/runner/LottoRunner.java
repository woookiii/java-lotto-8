package lotto.runner;

import lotto.domain.Lotto;
import lotto.controller.BonusNumberController;
import lotto.controller.CostController;
import lotto.controller.WinningNumbersController;
import lotto.domain.Statistic;
import lotto.enumeration.GuideMessage;
import lotto.enumeration.LottoNumber;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoRunner {

    private final LottoView lottoView = new LottoView();
    private final CostController costController = new CostController();
    private final WinningNumbersController winningNumbersController = new WinningNumbersController();
    private final BonusNumberController bonusNumberController = new BonusNumberController();
    private final LottoService lottoService = new LottoService();

    public void run() {
        lottoView.guideInput(GuideMessage.COST);
        final Integer cost = costController.repeatGetInputUntilRight();
        final Integer lottoCount = lottoService.costToLottoCount(cost, LottoNumber.PRICE);
        final List<Lotto> lottos = new ArrayList<>();
        lottoService.purchase(lottoCount, lottos);
        lottoView.guideInput(GuideMessage.WINNING_NUMBERS);
        final List<Integer> winningNumbers = winningNumbersController.repeatGetInputUntilRight();
        lottoView.guideInput(GuideMessage.BONUS_NUMBER);
        final Integer bonusNumber = bonusNumberController.repeatGetInputUntilRight(winningNumbers);
        Statistic statistic = lottoService.makeStatistic(lottos, winningNumbers, bonusNumber);
        final Integer profit = statistic.calculateProfit();
        final Double rateOfReturn = lottoService.calculateRateOfReturn(profit, cost);
    }


}
