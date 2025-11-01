package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {

    public void areNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            isNumberInRange(number, ErrorMessage.OUT_OF_BOUND_NUMBERS, LottoNumber.START_INCLUSIVE, LottoNumber.END_INCLUSIVE);
        }
    }

    public void isNumberInRange(Integer number, ErrorMessage errorMessage, LottoNumber startInclusive, LottoNumber endInclusive) {
        if (number < startInclusive.getValue() || number > endInclusive.getValue()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void areNumbersUnique(List<Integer> numbers, ErrorMessage errorMessage) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isNumbersSizeRight(List<Integer> numbers, ErrorMessage errorMessage) {
        if (numbers.size() != LottoNumber.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isBonusNumberUnique(Integer bonusNumber, List<Integer> winningNumbers, ErrorMessage errorMessage) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
