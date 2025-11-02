package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoValidatorTest {
    private final LottoValidator validator = new LottoValidator();

    @DisplayName("수들이 범위 안에 있을 때, 에러를 던지지 않는다.")
    @Test
    void areNumbersInRange_valid() {
        final List<Integer> validNumbers = Arrays.asList(1,2,3,4,5,6);

        assertDoesNotThrow(() -> validator.areNumbersInRange(validNumbers));
    }

    @DisplayName("수들 중에 범위 밖에 있는 수가 있을 때, 에러를 메시지와 함께 던진다.")
    @Test
    void areNumbersInRange_invalid() {
        final List<Integer> invalidNumbers = Arrays.asList(1,2,3,4,5,46);

        assertThatThrownBy(() -> validator.areNumbersInRange(invalidNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.OUT_OF_BOUND_NUMBERS.getMessage());
    }

    @DisplayName("숫자가 범위 안에 있을 때, 에러를 던지지 않는다.")
    @Test
    void isNumberInRange_valid() {
        final Integer validNumber = 10;

        assertDoesNotThrow(() ->
            validator.isNumberInRange(validNumber, ErrorMessage.OUT_OF_BOUND_NUMBERS, LottoNumber.START_INCLUSIVE, LottoNumber.END_INCLUSIVE)
        );
    }

    @DisplayName("숫자가 범위 밖일 때, 에러를 메시지와 함께 던진다.")
    @Test
    void isNumberInRange_invalid() {
        final Integer inValidNumber = 48;

        assertThatThrownBy(() -> validator.isNumberInRange(inValidNumber, ErrorMessage.OUT_OF_BOUND_NUMBERS, LottoNumber.START_INCLUSIVE, LottoNumber.END_INCLUSIVE))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.OUT_OF_BOUND_NUMBERS.getMessage());
    }

    @DisplayName("중복되지 않은 숫자들일 때, 에러를 던지지 않는다.")
    @Test
    void areNumbersUnique_valid() {
        final List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() ->
            validator.areNumbersUnique(validNumbers, ErrorMessage.NOT_UNIQUE_NUMBERS)
        );
    }

    @DisplayName("중복된 숫자가 일 때, 에러를 메시지와 함께 던진다.")
    @Test
    void areNumbersUnique_invalid() {
        final List<Integer> inValidNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);

        assertThatThrownBy(() -> validator.areNumbersUnique(inValidNumbers, ErrorMessage.NOT_UNIQUE_NUMBERS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NOT_UNIQUE_NUMBERS.getMessage());
    }

    @DisplayName("사이즈가 6일 때, 에러를 던지지 않는다.")
    @Test
    void isNumbersSizeRight_valid() {
        final List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() ->
            validator.isNumbersSizeRight(validNumbers, ErrorMessage.NOT_SIX_WINNING_NUMBERS)
        );
    }

    @DisplayName("사이즈가 6이 아닐때, 에러를 메시지와 함께 던진다.")
    @Test
    void isNumbersSizeRight_invalid() {
        final List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> validator.isNumbersSizeRight(invalidNumbers, ErrorMessage.NOT_SIX_WINNING_NUMBERS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NOT_SIX_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("보너스 숫자가 당첨번호와 중복되지 않을 때, 에러를 던지지 않는다.")
    @Test
    void isBonusNumberUnique_valid() {
        final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Integer validBonusNumber = 7;

        assertDoesNotThrow(() ->
            validator.isBonusNumberUnique(validBonusNumber, winningNumbers, ErrorMessage.NOT_UNIQUE_BONUS_NUMBER)
        );
    }

    @DisplayName("보너스 숫자가 당첨번호와 중복될 때, 에러를 메시지와 함께 던진다.")
    @Test
    void isBonusNumberUnique_invalid() {
        final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Integer invalidBonusNumber = 1;

        assertThatThrownBy(() -> validator.isBonusNumberUnique(invalidBonusNumber, winningNumbers, ErrorMessage.NOT_UNIQUE_BONUS_NUMBER))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NOT_UNIQUE_BONUS_NUMBER.getMessage());
    }
}