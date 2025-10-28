package lotto.validation;

public class InputFilter {

    public void validateCost(long cost) {
        if(cost % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 수를 입력해야 합니다.");
        }
    }

    public void validateInputIsNumeric(String input) {
        final boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if(!isNumeric) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 수를 입력해야 합니다.");
        }
    }
}
