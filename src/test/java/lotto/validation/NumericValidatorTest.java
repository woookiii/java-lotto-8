package lotto.validation;

import lotto.enumeration.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NumericValidatorTest {

    private final NumericValidator validator = new NumericValidator();

    @DisplayName("숫자 값이 들어오면 에러를 던지지 않는다.")
    @Test
    void isNumeric_valid() {
        assertDoesNotThrow(() ->
                validator.isNumeric("44", ErrorMessage.NOT_NUMERIC)
        );
    }

    @DisplayName("숫자가 아닌 값이 들어오면, 에러를 메시지와 함께 던진다.")
    @Test
    void isNumeric_invalid() {
        assertThatThrownBy(() -> validator.isNumeric("1마", ErrorMessage.NOT_NUMERIC))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMERIC.getMessage());
    }

    @DisplayName("숫자로 구성된 문자열 리스트가 들어오면 에러를 던지지 않는다.")
    @Test
    void isListNumeric_valid() {
        final List<String> validList = List.of("1", "23", "45", "1", "24", "21");

        assertDoesNotThrow(() ->
                validator.isListNumeric(validList)
        );
    }

    @DisplayName("숫자가 아닌 문자열이 포함된 리스트가 들어오면, 에러를 메시지와 함께 던진다.")
    @Test
    void isListNumeric_invalid() {
        final List<String> invalidList = List.of("1", "2a", "3", "4", "5", "6");

        assertThatThrownBy(() -> validator.isListNumeric(invalidList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMERIC.getMessage());
    }
}