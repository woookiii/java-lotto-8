package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumeration.Delimiter;
import lotto.enumeration.ErrorMessage;
import lotto.validation.LottoValidator;
import lotto.validation.NumericValidator;

import java.util.List;

public class WinningNumbersController {

    private final LottoValidator lottoValidator = new LottoValidator();
    private final NumericValidator numericValidator = new NumericValidator();

    public List<Integer> repeatGetInputUntilRight() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = getInput();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        return winningNumbers;
    }

    private List<Integer> getInput() {
        final String winningNumbersInput = Console.readLine();
        final List<String> parsedWinningNumbersInput = parseWinningNumbers(winningNumbersInput, Delimiter.COMMA);
        numericValidator.isListNumeric(parsedWinningNumbersInput);
        List<Integer> winningNumbers = getIntegerList(parsedWinningNumbersInput);
        lottoValidator.isNumbersSizeRight(winningNumbers, ErrorMessage.NOT_SIX_WINNING_NUMBERS);
        lottoValidator.areNumbersUnique(winningNumbers, ErrorMessage.NOT_UNIQUE_NUMBERS);
        lottoValidator.areNumbersInRange(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> getIntegerList(List<String> parsedWinningNumbersInput) {
        return parsedWinningNumbersInput.stream().map(Integer::parseInt).toList();
    }


    private List<String> parseWinningNumbers(String winningNumbersInput, Delimiter delimiter) {
        return List.of(winningNumbersInput.split(delimiter.getDelimiter()));
    }
}
