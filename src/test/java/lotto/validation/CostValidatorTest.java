package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CostValidatorTest {

    private final CostValidator validator = new CostValidator();

    @DisplayName("1000원으로_나누어_떨어지는_가격이_들어왔을_때_에러를_던지지_않는다")
    @Test
    void isCostLottoPriceTimes_validCost_doesNotThrow() {
        final Long cost = 3000L;
        final LottoNumber price = LottoNumber.PRICE;
        final ErrorMessage errorMessage = ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS;

        assertDoesNotThrow(() -> validator.isCostLottoPriceTimes(cost, errorMessage, price));
    }

    @DisplayName("1000원으로_나누어_떨어지지_않는_가격이_들어왔을_때_에러를_메시지와_함께_던진다")
    @Test
    void isCostLottoPriceTimes_invalidCost_throwsException() {
        final Long cost = 3500L;
        final LottoNumber price = LottoNumber.PRICE;
        final ErrorMessage errorMessage = ErrorMessage.NOT_THOUSAND_TIMES_NUMBERS;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.isCostLottoPriceTimes(cost, errorMessage, price)
        );
        assertEquals(errorMessage.getMessage(), exception.getMessage());
    }
}