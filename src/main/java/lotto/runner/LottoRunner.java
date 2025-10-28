package lotto.runner;

import lotto.ui.CostUI;

public class LottoRunner {
    private final CostUI costUI = new CostUI();

    public void run() {
        costUI.guideCostInput();
        long cost = costUI.repeatGetCostInputUntilRight();
    }
}
