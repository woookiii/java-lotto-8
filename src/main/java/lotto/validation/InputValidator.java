package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public static final int WINNING_NUMBERS_SIZE = 6;

    public void isCostLottoPriceTimes(Integer cost, ErrorMessage errorMessage, LottoNumber price) {
        if (cost % price.getValue() != 0) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isNumeric(String input, ErrorMessage errorMessage) {
        final boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void areNumbersInRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            isNumberInRange(winningNumber, ErrorMessage.OUT_OF_BOUND_NUMBERS, LottoNumber.START_INCLUSIVE, LottoNumber.END_INCLUSIVE);
        }
    }

    private void isNumberInRange(Integer winningNumber, ErrorMessage errorMessage, LottoNumber startInclusive, LottoNumber endInclusive) {
        if (winningNumber < startInclusive.getValue() || winningNumber > endInclusive.getValue()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }


    public void isListNumeric(List<String> parsedWinningNumbersInput) {
        for (String winningNumber : parsedWinningNumbersInput) {
            isNumeric(winningNumber, ErrorMessage.NOT_NUMERIC);
        }
    }

    public void areNumbersUnique(List<String> parsedWinningNumbersInput, ErrorMessage errorMessage) {
        if (parsedWinningNumbersInput.size() != new HashSet<>(parsedWinningNumbersInput).size()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isWinningNumbersSizeRight(List<String> winningNumbers, ErrorMessage errorMessage) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
