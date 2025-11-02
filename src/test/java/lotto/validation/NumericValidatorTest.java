package lotto.validation;

import lotto.enumeration.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumericValidatorTest {

    private final NumericValidator validator = new NumericValidator();

    @DisplayName("숫자_값이_들어오면_에러를_던지지_않는다")
    @Test
    void isNumeric_valid() {
        assertDoesNotThrow(() ->
                validator.isNumeric("44", ErrorMessage.NOT_NUMERIC)
        );
    }

    @DisplayName("숫자가_아닌_값이_들어오면_에러를_메시지와_함께_던진다")
    @Test
    void isNumeric_invalid() {
        final IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isNumeric("1마", ErrorMessage.NOT_NUMERIC)
        );
        assertEquals(ErrorMessage.NOT_NUMERIC.getMessage(), illegalArgumentException.getMessage());
    }

    @DisplayName("숫자로_구성된_문자열_리스트가_들어오면_에러를_던지지_않는다")
    @Test
    void isListNumeric_valid() {
        final List<String> validList = List.of("1", "23", "45", "1", "24", "21");

        assertDoesNotThrow(() ->
                validator.isListNumeric(validList)
        );
    }

    @DisplayName("숫자가_아닌_문자열이_포함된_리스트가_들어오면_에러를_메시지와_함께_던진다")
    @Test
    void isListNumeric_invalid() {
        final List<String> invalidList = List.of("1", "2a", "3", "4", "5", "6");

        final IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isListNumeric(invalidList)
        );
        assertEquals(ErrorMessage.NOT_NUMERIC.getMessage(), illegalArgumentException.getMessage());
    }
}