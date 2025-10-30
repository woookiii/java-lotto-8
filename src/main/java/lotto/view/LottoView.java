package lotto.view;

import lotto.domain.Lotto;
import lotto.enumeration.GuideMessage;

public class LottoView {

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
