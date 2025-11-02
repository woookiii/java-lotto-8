package lotto.validation;

import lotto.enumeration.ErrorMessage;
import lotto.enumeration.LottoNumber;

public class CostValidator {

    private static final int COST_INPUT_MAX_LENGTH = 9;

    public void isCostLottoPriceTimes(Long cost, ErrorMessage errorMessage, LottoNumber price) {
        if (cost % price.getValue() != 0) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isCostNotTooBig(String costInput, ErrorMessage errorMessage) {
        if (costInput.length() > COST_INPUT_MAX_LENGTH) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
