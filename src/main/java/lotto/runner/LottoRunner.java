package lotto.runner;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.ui.CostUI;
import lotto.validation.InputFilter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoRunner {
    private final CostUI costUI = new CostUI();
    private final LottoService lottoService = new LottoService();
    private final InputFilter inputFilter = new InputFilter();


    public void run() {
        costUI.guideCostInput();
        final Integer cost = costUI.repeatGetCostInputUntilRight();
        final Integer lottoCount = lottoService.costToLottoCount(cost);
        final List<Lotto> lottos = new ArrayList<>();
        lottoService.purchase(lottoCount, lottos);
        guideWinningNumbersInput();
        String winningNumbersInput = getInput();
        List<String> parsedWinningNumbersInput = parse(winningNumbersInput);
        validateSize(parsedWinningNumbersInput);
        validateNumbersAreUnique(parsedWinningNumbersInput);
        validateListIsNumeric(parsedWinningNumbersInput);

    }

    private void validateListIsNumeric(List<String> parsedWinningNumbersInput) {
        for (String winningNumber : parsedWinningNumbersInput) {
            inputFilter.validateInputIsNumeric(winningNumber);
        }
    }

    private static void validateNumbersAreUnique(List<String> parsedWinningNumbersInput) {
        if (parsedWinningNumbersInput.size() != new HashSet<>(parsedWinningNumbersInput).size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해야 합니다.");
        }
    }

    private static void validateSize(List<String> winningNumbers) {
        if(winningNumbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private static List<String> parse(String winningNumbersInput) {
        return List.of(winningNumbersInput.split(","));
    }

    private String getInput() {
        return Console.readLine();
    }

    private void guideWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

}
