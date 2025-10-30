package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumeration.ErrorMessage;
import lotto.validation.InputValidator;

import java.util.List;

public class WinningNumbersController {
    private final InputValidator inputValidator = new InputValidator();

    public List<Integer> repeatGetInputUntilRight() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = getInput();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        }
        return winningNumbers;
    }

    private List<Integer> getInput() {
        final String winningNumbersInput = Console.readLine();
        final List<String> parsedWinningNumbersInput = parse(winningNumbersInput);
        inputValidator.isWinningNumbersSizeRight(parsedWinningNumbersInput, ErrorMessage.NOT_SIX_NUMBERS);
        inputValidator.areNumbersUnique(parsedWinningNumbersInput, ErrorMessage.NOT_UNIQUE_NUMBERS);
        inputValidator.isListNumeric(parsedWinningNumbersInput);
        List<Integer> winningNumbers = getIntegerList(parsedWinningNumbersInput);
        inputValidator.areNumbersInRange(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> getIntegerList(List<String> parsedWinningNumbersInput) {
        return parsedWinningNumbersInput.stream().map(Integer::parseInt).toList();
    }


    private List<String> parse(String winningNumbersInput) {
        return List.of(winningNumbersInput.split(","));
    }
}
