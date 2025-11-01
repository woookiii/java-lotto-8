package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;

public class CostValidator {

    public void isCostLottoPriceTimes(Long cost, ErrorMessage errorMessage, LottoNumber price) {
        if (cost % price.getValue() != 0) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
