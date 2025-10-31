package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import lotto.validation.InputValidator;

import java.util.List;

public class BonusNumberController {

    private final InputValidator inputValidator = new InputValidator();

    public Integer repeatGetInputUntilRight(List<Integer> winningNumbers) {
        Integer bonusNumber;
        while (true) {
            try {
                bonusNumber = getInput(winningNumbers);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        return bonusNumber;
    }

    private Integer getInput(List<Integer> winningNumbers) {
        final String bonusNumberInput = Console.readLine();
        inputValidator.isNumeric(bonusNumberInput, ErrorMessage.NOT_NUMERIC);
        Integer bonusNumber = Integer.parseInt(bonusNumberInput);
        inputValidator.isNumberInRange(bonusNumber, ErrorMessage.OUT_OF_BOUND_NUMBERS, LottoNumber.START_INCLUSIVE, LottoNumber.END_INCLUSIVE);
        inputValidator.isBonusNumberUnique(bonusNumber, winningNumbers, ErrorMessage.NOT_UNIQUE_BONUS_NUMBER);
        return bonusNumber;
    }

}
