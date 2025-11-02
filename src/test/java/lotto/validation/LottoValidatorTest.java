package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {
    private final LottoValidator validator = new LottoValidator();

    @DisplayName("수들이_범위_안에_있을_때_에러를_던지지_않는다")
    @Test
    void areNumbersInRange_valid() {
        final List<Integer> validNumbers = Arrays.asList(1,2,3,4,5,6);

        assertDoesNotThrow(() -> validator.areNumbersInRange(validNumbers));
    }

    @DisplayName("수들중에_범위_밖에_있는_수가_있을_때_에러를_메시지와_함께_던진다")
    @Test
    void areNumbersInRange_invalid() {
        final List<Integer> invalidNumbers = Arrays.asList(1,2,3,4,5,46);

        final IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.areNumbersInRange(invalidNumbers)
        );

        assertEquals(ErrorMessage.OUT_OF_BOUND_NUMBERS.getMessage(), exception.getMessage());
    }

    @DisplayName("숫자가_범위_안에_있을_때_에러를_던지지_않는다")
    @Test
    void isNumberInRange_valid() {
        final Integer validNumber = 10;

        assertDoesNotThrow(() ->
                validator.isNumberInRange(validNumber, ErrorMessage.OUT_OF_BOUND_NUMBERS, LottoNumber.START_INCLUSIVE, LottoNumber.END_INCLUSIVE)
        );
    }

    @DisplayName("숫자가_범위_밖일_때_에러를_메시지와_함께_던진다")
    @Test
    void isNumberInRange_invalid() {
        final Integer inValidNumber = 48;

        final IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isNumberInRange(inValidNumber, ErrorMessage.OUT_OF_BOUND_NUMBERS, LottoNumber.START_INCLUSIVE, LottoNumber.END_INCLUSIVE)
        );
        assertEquals(ErrorMessage.OUT_OF_BOUND_NUMBERS.getMessage(), ex.getMessage());
    }

    @DisplayName("중복되지_않은_숫자들일_때_에러를_던지지_않는다")
    @Test
    void areNumbersUnique_valid() {
        final List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() ->
                validator.areNumbersUnique(validNumbers, ErrorMessage.NOT_UNIQUE_NUMBERS)
        );
    }

    @DisplayName("중복된_숫자가_일_때_에러를_메시지와_함께_던진다")
    @Test
    void areNumbersUnique_invalid() {
        final List<Integer> inValidNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);

        final IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.areNumbersUnique(inValidNumbers, ErrorMessage.NOT_UNIQUE_NUMBERS)
        );
        assertEquals(ErrorMessage.NOT_UNIQUE_NUMBERS.getMessage(), ex.getMessage());
    }

    @DisplayName("사이즈가_6일_때_에러를_던지지_않는다")
    @Test
    void isNumbersSizeRight_valid() {
        final List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() ->
                validator.isNumbersSizeRight(validNumbers, ErrorMessage.NOT_SIX_WINNING_NUMBERS)
        );
    }

    @DisplayName("사이즈가_6이_아닐때_에러를_메시지와_함께_던진다")
    @Test
    void isNumbersSizeRight_invalid() {
        final List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        final IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isNumbersSizeRight(invalidNumbers, ErrorMessage.NOT_SIX_WINNING_NUMBERS)
        );
        assertEquals(ErrorMessage.NOT_SIX_WINNING_NUMBERS.getMessage(), ex.getMessage());
    }

    @DisplayName("보너스_숫자가_당첨번호와_중복되지_않을_때_에러를_던지지_않는다")
    @Test
    void isBonusNumberUnique_valid() {
        final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Integer validBonusNumber = 7;

        assertDoesNotThrow(() ->
                validator.isBonusNumberUnique(validBonusNumber, winningNumbers, ErrorMessage.NOT_UNIQUE_BONUS_NUMBER)
        );
    }

    @DisplayName("보너스_숫자가_당첨번호와_중복될_때_에러를_메시지와_함께_던진다")
    @Test
    void isBonusNumberUnique_invalid() {
        final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Integer invalidBonusNumber = 1;

        final IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isBonusNumberUnique(invalidBonusNumber, winningNumbers, ErrorMessage.NOT_UNIQUE_BONUS_NUMBER)
        );
        assertEquals(ErrorMessage.NOT_UNIQUE_BONUS_NUMBER.getMessage(), ex.getMessage());
    }
}