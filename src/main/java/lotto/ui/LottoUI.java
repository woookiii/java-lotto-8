package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.enumeration.ErrorMessage;
import lotto.enumeration.GuideMessage;
import lotto.validation.InputValidator;

import java.util.List;

public class LottoUI {

    private final InputValidator inputValidator = new InputValidator();

    public List<Integer> repeatGetWinningNumbersInputUntilRight() {
        List<Integer> winningNumbers;
        while(true){
            try{
                winningNumbers = getWinningNumbersInput();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        }
        return winningNumbers;
    }

    private List<Integer> getWinningNumbersInput() {
        final String winningNumbersInput = Console.readLine();
        final List<String> parsedWinningNumbersInput = parse(winningNumbersInput);
        inputValidator.isWinningNumbersSizeRight(parsedWinningNumbersInput, ErrorMessage.NOT_SIX_NUMBERS);
        inputValidator.areNumbersUnique(parsedWinningNumbersInput, ErrorMessage.NOT_UNIQUE_NUMBERS);
        inputValidator.isListNumeric(parsedWinningNumbersInput);
        List<Integer> winningNumbers = getIntegerList(parsedWinningNumbersInput);
        inputValidator.areNumbersInRange(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> getIntegerList(List<String> parsedWinningNumbersInput) {
        return parsedWinningNumbersInput.stream().map(Integer::parseInt).toList();
    }


    private List<String> parse(String winningNumbersInput) {
        return List.of(winningNumbersInput.split(","));
    }

    public void showNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void showLottoCount(Integer lottoCount) {
        System.out.format("%n%d개를 구매했습니다.%n", lottoCount);
    }

    public void guideInput(GuideMessage guideMessage) {
        System.out.println(guideMessage.getMessage());
    }
}
