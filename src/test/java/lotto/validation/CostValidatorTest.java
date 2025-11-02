package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;


class CostValidatorTest {

    private final CostValidator validator = new CostValidator();

    @DisplayName("1000원으로_나누어_떨어지는_가격이_들어왔을_때_에러를_던지지_않는다")
    @Test
    void isCostLottoPriceTimes_valid() {
        final Long cost = 3000L;

        assertDoesNotThrow(() -> validator.isCostLottoPriceTimes(cost, ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS, LottoNumber.PRICE));
    }

    @DisplayName("1000원으로_나누어_떨어지지_않는_가격이_들어왔을_때_에러를_메시지와_함께_던진다")
    @Test
    void isCostLottoPriceTimes_invalid() {
        final Long cost = 3500L;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isCostLottoPriceTimes(cost, ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS, LottoNumber.PRICE)
        );
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS.getMessage());
    }

    @DisplayName("정해둔_길이_미만의_수를_입력할_시_에러를_던지지_않는다")
    @Test
    void isCostNotTooBig_valid() {
        final String validInput = "999999000";

        assertDoesNotThrow(() -> validator.isCostNotTooBig(validInput, ErrorMessage.TOO_BIG_COST));
    }

    @DisplayName("정해둔_길이_이상의_수를_입력할_시_에러를_메시지와_함께_던진다")
    @Test
    void isCostNotTooBig_invalid() {
        final String invalidInput = "1234567890";

        final IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isCostNotTooBig(invalidInput, ErrorMessage.TOO_BIG_COST)
        );
        assertThat(illegalArgumentException.getMessage()).isEqualTo(ErrorMessage.TOO_BIG_COST.getMessage());
    }
}