package lotto;

import lotto.ui.CostUI;

public class Application {
    public static void main(String[] args) {

        final CostUI costUI = new CostUI();

        costUI.guideCostInput();
        long cost = costUI.repeatGetCostInputUntilRight();
    }


}
