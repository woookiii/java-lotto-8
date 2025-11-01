package lotto.domain;

import lotto.enumeration.ErrorMessage;
import lotto.validation.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        final LottoValidator lottoValidator = new LottoValidator();
        lottoValidator.isNumbersSizeRight(numbers, ErrorMessage.NOT_SIX_LOTTO_NUMBERS);
        lottoValidator.areNumbersUnique(numbers, ErrorMessage.NOT_UNIQUE_NUMBERS);
        lottoValidator.areNumbersInRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
