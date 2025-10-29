package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import lotto.validation.InputValidator;

public class CostUI {

    private final InputValidator inputValidator = new InputValidator();

    public Integer repeatGetCostInputUntilRight() {
        Integer cost;
        while (true) {
            final String costInput = Console.readLine();
            try {
                inputValidator.isNumeric(costInput, ErrorMessage.NOT_NUMERIC);
                cost = Integer.parseInt(costInput);
                inputValidator.isCostLottoPriceTimes(cost, ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS, LottoNumber.PRICE);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        }
        return cost;
    }




}
