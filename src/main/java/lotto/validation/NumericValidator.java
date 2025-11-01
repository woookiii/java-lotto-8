package lotto.validation;

import lotto.enumeration.ErrorMessage;

import java.util.List;

public class NumericValidator {
    public void isNumeric(String input, ErrorMessage errorMessage) {
        final boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isListNumeric(List<String> parsedWinningNumbersInput) {
        for (String winningNumber : parsedWinningNumbersInput) {
            isNumeric(winningNumber, ErrorMessage.NOT_NUMERIC);
        }
    }
}
