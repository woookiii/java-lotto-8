package lotto.enumeration;

public enum ErrorMessage {

    NOT_THOUSAND_TIMES_NUMBERS("[ERROR] 1000원으로 나누어 떨어지는 양수를 입력해야 합니다."),
    NOT_NUMERIC("[ERROR] 숫자를 입력해야 합니다."),
    OUT_OF_BOUND_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_UNIQUE_NUMBERS("[ERROR] 중복되지 않은 숫자를 입력해야 합니다."),
    NOT_UNIQUE_BONUS_NUMBER("[ERROR] 당첨번호와 중복되지 않은 숫자를 입력해야 합니다."),
    NOT_SIX_LOTTO_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_SIX_WINNING_NUMBERS("[ERROR] 당첨 번호는 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
