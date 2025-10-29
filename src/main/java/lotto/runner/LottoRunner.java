package lotto.runner;

import lotto.ui.CostUI;

public class LottoRunner {
    private final CostUI costUI = new CostUI();


    public void run() {
        costUI.guideCostInput();
        Integer cost = costUI.repeatGetCostInputUntilRight();
        Integer lottoCount = costToLottoCount(cost);
    }

    private Integer costToLottoCount(Integer cost) {
        return cost / 1000;
    }
}
