package lotto.runner;

import lotto.ui.CostUI;

public class LottoRunner {
    private final CostUI costUI = new CostUI();


    public void run() {
        costUI.guideCostInput();
        Integer cost = costUI.repeatGetCostInputUntilRight();
        Integer lottoCount = costToLottoCount(cost);
        showLottoCount(lottoCount);
    }

    private static void showLottoCount(Integer lottoCount) {
        System.out.format("%n%d개를 구매했습니다.", lottoCount);
    }

    private Integer costToLottoCount(Integer cost) {
        return cost / 1000;
    }
}
