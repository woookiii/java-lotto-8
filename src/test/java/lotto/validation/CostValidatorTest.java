package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CostValidatorTest {

    private final CostValidator validator = new CostValidator();

    @DisplayName("1000원으로 나누어 떨어지는 가격이 들어왔을 때, 에러를 던지지 않는다.")
    @Test
    void isCostLottoPriceTimes_valid() {
        final Long cost = 3000L;

        assertDoesNotThrow(() -> validator.isCostLottoPriceTimes(cost, ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS, LottoNumber.PRICE));
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 가격이 들어왔을 때, 에러를 메시지와 함께 던진다.")
    @Test
    void isCostLottoPriceTimes_invalid() {
        final Long cost = 3500L;

        assertThatThrownBy(() -> validator.isCostLottoPriceTimes(cost, ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS, LottoNumber.PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS.getMessage());
    }

    @DisplayName("정해둔 길이 미만의 수를 입력할 시, 에러를 던지지 않는다.")
    @Test
    void isCostNotTooBig_valid() {
        final String validInput = "999999000";

        assertDoesNotThrow(() -> validator.isCostNotTooBig(validInput, ErrorMessage.TOO_BIG_COST));
    }

    @DisplayName("정해둔 길이 이상의 수를 입력할 시, 에러를 메시지와 함께 던진다.")
    @Test
    void isCostNotTooBig_invalid() {
        final String invalidInput = "1234567890";

        assertThatThrownBy(() -> validator.isCostNotTooBig(invalidInput, ErrorMessage.TOO_BIG_COST))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TOO_BIG_COST.getMessage());
    }
}