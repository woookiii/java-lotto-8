package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import lotto.validation.InputValidator;

public class CostController {

    private final InputValidator inputValidator = new InputValidator();

    public Long repeatGetInputUntilRight() {
        Long cost;
        while (true) {
            try {
                cost = getInput();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        }
        return cost;
    }

    private Long getInput() {
        final String costInput = Console.readLine();
        inputValidator.isNumeric(costInput, ErrorMessage.NOT_NUMERIC);
        Long cost = Long.parseLong(costInput);
        inputValidator.isCostLottoPriceTimes(cost, ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS, LottoNumber.PRICE);

        return cost;
    }
}
