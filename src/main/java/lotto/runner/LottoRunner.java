package lotto.runner;

import lotto.Lotto;
import lotto.controller.CostController;
import lotto.controller.WinningNumbersController;
import lotto.enumeration.GuideMessage;
import lotto.enumeration.LottoNumber;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoRunner {

    private final LottoView lottoView = new LottoView();
    private final WinningNumbersController winningNumbersController = new WinningNumbersController();
    private final CostController costController = new CostController();
    private final LottoService lottoService = new LottoService();

    public void run() {
        lottoView.guideInput(GuideMessage.COST);
        final Integer cost = costController.repeatGetInputUntilRight();
        final Integer lottoCount = lottoService.costToLottoCount(cost, LottoNumber.PRICE);
        final List<Lotto> lottos = new ArrayList<>();
        lottoService.purchase(lottoCount, lottos);
        lottoView.guideInput(GuideMessage.WINNING_NUMBERS);
        final List<Integer> winningNumbers = winningNumbersController.repeatGetInputUntilRight();
    }


}
