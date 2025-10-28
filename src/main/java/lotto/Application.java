package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputFilter;

public class Application {
    public static void main(String[] args) {

        final InputFilter inputFilter = new InputFilter();

        guideCostInput();

        final String costInput = getInput();

        long cost;
        try{
            inputFilter.validateInputIsNumeric(costInput);
            cost = Long.parseLong(costInput);
            inputFilter.validateCost(cost);
        } catch(IllegalArgumentException illegalArgumentException) {
            System.err.println(illegalArgumentException.getMessage());
        }


    }



    private static String getInput() {
        return Console.readLine();
    }

    private static void guideCostInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
