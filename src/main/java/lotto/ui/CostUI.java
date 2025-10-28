package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputFilter;

public class CostUI {

    private final InputFilter inputFilter = new InputFilter();

    public long repeatGetCostInputUntilRight() {
        long cost;
        while (true) {
            final String costInput = getInput();
            try {
                inputFilter.validateInputIsNumeric(costInput);
                cost = Long.parseLong(costInput);
                inputFilter.validateCost(cost);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        }
        return cost;
    }


    private String getInput() {
        return Console.readLine();
    }


    public void guideCostInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

}
