package lotto.domain;

import lotto.enumeration.ErrorMessage;
import lotto.validation.InputValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        InputValidator validator = new InputValidator();
        validator.areNumbersUnique(numbers, ErrorMessage.NOT_UNIQUE_WINNING_NUMBERS);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
